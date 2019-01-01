package com.rebindtech.tiffin.servicebean;

import com.rebindtech.tiffin.constants.AppMsgConstant;
import com.rebindtech.tiffin.constants.MsgConstant;
import com.rebindtech.tiffin.constants.QueryConstant;
import com.rebindtech.tiffin.constants.TiffinSysConstant;
import com.rebindtech.tiffin.dto.AddressMasterDTO;
import com.rebindtech.tiffin.dto.CustomerDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.dto.core.SmsDTO;
import com.rebindtech.tiffin.entity.LoginMaster;
import com.rebindtech.tiffin.customer.AddressMaster;
import com.rebindtech.tiffin.customer.TiffinCustomer;
import com.rebindtech.tiffin.entity.CustomerFeedback;
import com.rebindtech.tiffin.entity.Recharge;
import com.rebindtech.tiffin.service.CustomerService;
import com.rebindtech.tiffin.utils.Encryption;
import com.rebindtech.tiffin.utils.TiffinDateUtils;
import com.rebindtech.tiffin.utils.TiffinStringUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Sagar
 */
@Stateless
public class CustomerServiceBean implements CustomerService {

    @PersistenceContext
    EntityManager em;

   @EJB
    SMSHelper smsHelper;

    @EJB
    DeviceNotificationHelper notificationHelper;

    @Override
    public MessageDTO addCustomer(Integer customerID, String fullName, String emailID,
            BigInteger mobileNumber, String password, String referralCode) {
        MessageDTO messageDTO = new MessageDTO();
        TiffinCustomer tiffinCustomer;
        Boolean isOldSignup = Boolean.FALSE;
        if (customerID == null) {
            tiffinCustomer = checkMobileAlreadyRegistered(mobileNumber);
            if (tiffinCustomer != null && tiffinCustomer.getMobileActivationDateTime() != null) {
                messageDTO.setMessageID(MsgConstant.SMS_PHONE_DUPLICATE_ID);
                messageDTO.setMessageText(MsgConstant.SMS_PHONE_DUPLICATE_TEXT);
                return messageDTO;
            }
            if (tiffinCustomer != null) {
                customerID = tiffinCustomer.getCustomerID();
                isOldSignup = Boolean.TRUE;
            }
            tiffinCustomer = checkEmailAlreadyRegistered(emailID);
            if (tiffinCustomer != null && tiffinCustomer.getMobileActivationDateTime() != null) {
                messageDTO.setMessageID(MsgConstant.EMAIL_DUPLICATE_ID);
                messageDTO.setMessageText(MsgConstant.EMAIL_DUPLICATE_TEXT);
                return messageDTO;
            }
            if (tiffinCustomer != null) {
                customerID = tiffinCustomer.getCustomerID();
                isOldSignup = Boolean.TRUE;
            }
        }
        tiffinCustomer = mapTiffinCustomer(customerID, fullName, emailID, mobileNumber, password, referralCode);
        try {
            if (tiffinCustomer != null) {
                if (customerID == null) {
                    em.persist(tiffinCustomer);
                    //Code to send tpin Email/SMS
                    SmsDTO smsDTO = createSMSDTO(tiffinCustomer);
                    smsHelper.sendSMS(smsDTO);
                    try {
                        smsHelper.sendAdminNotification(tiffinCustomer);
                    } catch (Exception e) {

                    }
                    messageDTO.setMessageID(MsgConstant.INSERT_SUCCESS_ID);
                    messageDTO.setMessageText(MsgConstant.INSERT_SUCCESS_TEXT);
                } else {
                    em.merge(tiffinCustomer);
                    if (isOldSignup) {
                        SmsDTO smsDTO = createSMSDTO(tiffinCustomer);
                        smsHelper.sendSMS(smsDTO);
                    }
                    messageDTO.setMessageID(MsgConstant.INSERT_SUCCESS_ID);
                    messageDTO.setMessageText(MsgConstant.INSERT_SUCCESS_TEXT);
                }
                CustomerDTO customer = mapCustomerDTO(tiffinCustomer);
                messageDTO.setCustomer(customer);
            } else {
                messageDTO.setMessageID(MsgConstant.FAILURE_ID);
                messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
            }
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private TiffinCustomer mapTiffinCustomer(Integer customerID, String fullName, String emailID, BigInteger mobileNumber,
            String password, String referralCode) {
        TiffinCustomer tiffinCustomer;
        String tpin = TiffinStringUtils.createTpin(5);
        String emailKey = TiffinStringUtils.createRandomString(6);
        if (customerID != null) {
            tiffinCustomer = em.find(TiffinCustomer.class, customerID);
            if (tiffinCustomer == null) {
                return null;
            }
        } else {
            tiffinCustomer = new TiffinCustomer();
            tiffinCustomer.setTpinCount(1);
            tiffinCustomer.setSMSPhone(mobileNumber);
            tiffinCustomer.setTpin(tpin);
            tiffinCustomer.setEmailKey(emailKey);
            if (StringUtils.isNotBlank(referralCode)) {
                tiffinCustomer.setRefereeCode(referralCode);
            }
            String selfReferralCode = TiffinStringUtils.createRandomString(10);
            tiffinCustomer.setReferralCode(selfReferralCode);
            tiffinCustomer.setTpinSendDateTime(TiffinDateUtils.getCurrentDateAndTime());
            tiffinCustomer.setEmailKeySendDateTime(TiffinDateUtils.getCurrentDateAndTime());
            tiffinCustomer.setEmailActivationDateTime(TiffinDateUtils.getCurrentDateAndTime());
            tiffinCustomer.setTCAcceptedDateTime(TiffinDateUtils.getCurrentDateAndTime());
            tiffinCustomer.setCreatedDateTime(TiffinDateUtils.getCurrentDateAndTime());
            tiffinCustomer.setRequestedPassword(Encryption.encryptPassword(password));
        }
        tiffinCustomer.setFullName(fullName);
        tiffinCustomer.setEmailID(emailID);
        return tiffinCustomer;
    }

    private CustomerDTO mapCustomerDTO(TiffinCustomer tiffinCustomer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerID(tiffinCustomer.getCustomerID().toString());
        customerDTO.setFullName(tiffinCustomer.getFullName());
        customerDTO.setsMSPhone(tiffinCustomer.getSMSPhone().toString());
        if (tiffinCustomer.getSmallBiteWallet() != null) {
            customerDTO.setSmallBiteMoney(tiffinCustomer.getSmallBiteWallet().toString());
        } else {
            customerDTO.setSmallBiteMoney(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(tiffinCustomer.getEmailID())) {
            customerDTO.setEmailID(tiffinCustomer.getEmailID());
        }else{
            customerDTO.setEmailID(TiffinSysConstant.EMPTY_STRING);
        }
        customerDTO.setCreatedDateTime(TiffinDateUtils.getFormattedDateString(tiffinCustomer.getCreatedDateTime()));
        if (tiffinCustomer.getMobileActivationDateTime() != null) {
            customerDTO.setMobileActivationDateTime(TiffinDateUtils.getFormattedDateString(tiffinCustomer.getMobileActivationDateTime()));
        } else {
            customerDTO.setMobileActivationDateTime(TiffinSysConstant.EMPTY_STRING);
        }
        if (tiffinCustomer.getEmailActivationDateTime() != null) {
            customerDTO.setEmailActivationDateTime(TiffinDateUtils.getFormattedDateString(tiffinCustomer.getEmailActivationDateTime()));
        } else {
            customerDTO.setEmailActivationDateTime(TiffinSysConstant.EMPTY_STRING);
        }
        if (tiffinCustomer.getLocalityID() != null) {
            customerDTO.setLocalityID(tiffinCustomer.getLocalityID().toString());
        } else {
            customerDTO.setLocalityID(TiffinSysConstant.EMPTY_STRING);
        }
        if (tiffinCustomer.getIsFreeDelivery() != null) {
            customerDTO.setIsFreeDelivery(tiffinCustomer.getIsFreeDelivery());
        } else {
            customerDTO.setIsFreeDelivery(Boolean.TRUE);
        }
        if (StringUtils.isNotBlank(tiffinCustomer.getPackagingType())) {
            customerDTO.setPackagingType(tiffinCustomer.getPackagingType());
        } else {
            customerDTO.setPackagingType(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(tiffinCustomer.getReferralCode())) {
            customerDTO.setReferralCode(tiffinCustomer.getReferralCode());
        } else {
            customerDTO.setReferralCode(TiffinSysConstant.EMPTY_STRING);
        }
        List<AddressMaster> addressList = tiffinCustomer.getAddressMasterList();
        List<AddressMasterDTO> addressMasterDTOs = new ArrayList<AddressMasterDTO>();
        if (addressList != null && !addressList.isEmpty()) {
            for (AddressMaster addressMaster : addressList) {
                AddressMasterDTO addressMasterDTO = mapAddressMasterDTO(addressMaster);
                addressMasterDTOs.add(addressMasterDTO);
            }
            customerDTO.setAddressList(addressMasterDTOs);
        } else {
            customerDTO.setAddressList(addressMasterDTOs);
        }
        return customerDTO;
    }

    @Override
    public MessageDTO verifyPin(Integer customerID, String pin, String type, Boolean isForget) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            if (customerID != null) {
                TiffinCustomer tiffinCustomer = em.find(TiffinCustomer.class, customerID);
                if (tiffinCustomer != null) {
                    if (type.equals("Mobile")
                            && pin.equals(tiffinCustomer.getTpin())) {
                        tiffinCustomer.setMobileActivationDateTime(TiffinDateUtils.getCurrentDateAndTime());
                        em.merge(tiffinCustomer);
                        if (isForget == null || !isForget) {
                            createLginMasterEntry(tiffinCustomer, null);
                        }
                        // code to send welcome sms to customer
                        messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
                        messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
                    } else if (type.equals("Email")
                            && pin.equals(tiffinCustomer.getEmailKey())) {
                        tiffinCustomer.setEmailActivationDateTime(TiffinDateUtils.getCurrentDateAndTime());
                        em.merge(tiffinCustomer);
                        // code to send welcome sms to customer
                        messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
                        messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
                    }
                } else {
                    messageDTO.setMessageID(MsgConstant.FAILURE_ID);
                    messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
                }
            }
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private AddressMasterDTO mapAddressMasterDTO(AddressMaster addressMaster) {
        AddressMasterDTO addressMasterDTO = new AddressMasterDTO();
        addressMasterDTO.setAddressMasterID(addressMaster.getAddressMasterID().toString());
        addressMasterDTO.setAddressTag(addressMaster.getAddressTag());
        addressMasterDTO.setAddressLine1(addressMaster.getAddressLine1());
        addressMasterDTO.setAddressLine2(addressMaster.getAddressLine2());
        if (StringUtils.isNotBlank(addressMaster.getLocality())) {
            addressMasterDTO.setLocality(addressMaster.getLocality());
        } else {
            addressMasterDTO.setLocality(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(addressMaster.getCity())) {
            addressMasterDTO.setCity(addressMaster.getCity());
        } else {
            addressMasterDTO.setCity(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(addressMaster.getState())) {
            addressMasterDTO.setState(addressMaster.getState());
        } else {
            addressMasterDTO.setState(TiffinSysConstant.EMPTY_STRING);
        }
        addressMasterDTO.setPincode(addressMaster.getPincode());
        if (StringUtils.isNotBlank(addressMaster.getLattitude())) {
            addressMasterDTO.setLattitude(addressMaster.getLattitude());
        } else {
            addressMasterDTO.setLattitude(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(addressMaster.getLongitude())) {
            addressMasterDTO.setLongitude(addressMaster.getLongitude());
        } else {
            addressMasterDTO.setLongitude(addressMaster.getLongitude());
        }
        return addressMasterDTO;
    }

    @Override
    public MessageDTO addAddress(AddressMasterDTO addressMasterDTO) {
        MessageDTO messageDTO = new MessageDTO();
        AddressMaster addressMaster = mapAddressMaster(addressMasterDTO);
        try {
            if (StringUtils.isNotBlank(addressMasterDTO.getAddressMasterID())) {
                em.merge(addressMaster);
                messageDTO.setMessageID(MsgConstant.UPDATE_SUCCESS_ID);
                messageDTO.setMessageText(MsgConstant.UPDATE_SUCCESS_TEXT);
            } else {
                em.persist(addressMaster);
                //Code to send tpin Email/SMS
                messageDTO.setMessageID(MsgConstant.INSERT_SUCCESS_ID);
                messageDTO.setMessageText(MsgConstant.INSERT_SUCCESS_TEXT);
            }
            AddressMasterDTO address = mapAddressMasterDTO(addressMaster);
            messageDTO.setAddress(address);
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private AddressMaster mapAddressMaster(AddressMasterDTO addressMasterDTO) {
        AddressMaster addressMaster;

        if (StringUtils.isNotBlank(addressMasterDTO.getAddressMasterID())) {
            addressMaster = em.find(AddressMaster.class, Integer.parseInt(addressMasterDTO.getAddressMasterID()));
            if (addressMaster != null) {
                return null;
            }
        } else {
            addressMaster = new AddressMaster();
            addressMaster.setCreatedDateTime(TiffinDateUtils.getCurrentDateAndTime());
//            TiffinCustomer tiffinCustomer = em.find(TiffinCustomer.class, Integer.parseInt(addressMasterDTO.getCustomerID()));
            addressMaster.setCustomerID(new TiffinCustomer(Integer.parseInt(addressMasterDTO.getCustomerID())));
        }
        addressMaster.setAddressTag(addressMasterDTO.getAddressTag());
        addressMaster.setAddressLine1(addressMasterDTO.getAddressLine1());
        addressMaster.setAddressLine2(addressMasterDTO.getAddressLine2());
        addressMaster.setLocality(addressMasterDTO.getLocality());
        addressMaster.setCity(addressMasterDTO.getCity());
        addressMaster.setState(addressMasterDTO.getState());
        addressMaster.setPincode(addressMasterDTO.getPincode());
        if (StringUtils.isNotBlank(addressMasterDTO.getLattitude())) {
            addressMaster.setLattitude(addressMasterDTO.getLattitude());
        }
        if (StringUtils.isNotBlank(addressMasterDTO.getLongitude())) {
            addressMaster.setLongitude(addressMasterDTO.getLongitude());
        }
        return addressMaster;
    }

    @Override
    public CustomerDTO getCustomer(Integer customerID) {
        CustomerDTO customerDTO = new CustomerDTO();
        TiffinCustomer tiffinCustomer = em.find(TiffinCustomer.class, customerID);
        if (tiffinCustomer != null) {
            customerDTO = mapCustomerDTO(tiffinCustomer);
        }
        return customerDTO;
    }

    private TiffinCustomer checkMobileAlreadyRegistered(BigInteger smsPhone) {
        TiffinCustomer tiffinCustomer = null;
        try {
            Query query = em.createNativeQuery(QueryConstant.GET_USER_COUNT_BY_MOBILE_NUMBER, TiffinCustomer.class)
                    .setParameter("smsPhone", smsPhone);
            List<TiffinCustomer> customers = query.getResultList();
            if (!customers.isEmpty()) {
                tiffinCustomer = customers.get(0);
            }
        } catch (NoResultException nre) {
            return tiffinCustomer;
        }
        return tiffinCustomer;
    }

    private TiffinCustomer checkEmailAlreadyRegistered(String emailID) {
        TiffinCustomer tiffinCustomer = null;
        try {
            if (StringUtils.isNotBlank(emailID)) {
                Query query = em.createNativeQuery(QueryConstant.GET_USER_COUNT_BY_EMAIL, TiffinCustomer.class)
                        .setParameter("emailID", emailID);
                List<TiffinCustomer> customers = query.getResultList();
                if (!customers.isEmpty()) {
                    return customers.get(0);
                }
            }
        } catch (NoResultException nre) {
            return tiffinCustomer;
        }
        return tiffinCustomer;
    }

    private SmsDTO createSMSDTO(TiffinCustomer tiffinCustomer) {
        SmsDTO smsDTO = new SmsDTO();
        smsDTO.setReceiverID(tiffinCustomer.getCustomerID());
        smsDTO.setReceiverName(tiffinCustomer.getFullName());
        smsDTO.setAuthToken(tiffinCustomer.getTpin());
        smsDTO.setSmsNumber(tiffinCustomer.getSMSPhone());
        smsDTO.setSmsReasonID(1);
        return smsDTO;
    }

    private void createLginMasterEntry(TiffinCustomer tiffinCustomer, String password) {
        LoginMaster loginMaster = new LoginMaster();
        loginMaster.setUserID(tiffinCustomer.getCustomerID());
        loginMaster.setPrivateChavi(tiffinCustomer.getRequestedPassword());
        loginMaster.setPrivateDoor(tiffinCustomer.getSMSPhone());
        em.persist(loginMaster);

    }

    @Override
    public MessageDTO addDeviceID(Integer customerID, Integer deviceID) {
        MessageDTO messageDTO = new MessageDTO();
        Query query = em.createNativeQuery(QueryConstant.UPDATE_DEVICE_ID_BY_CUSTOMER_ID)
                .setParameter("deviceID", deviceID)
                .setParameter("customerID", customerID);
        Integer rowCount = query.executeUpdate();
        if (rowCount > 0) {
            messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
        } else {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    @Override
    public MessageDTO reSendPin(Integer customerID, String mobileNumber) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            TiffinCustomer tiffinCustomer = null;
            if (customerID != null) {
                tiffinCustomer = em.find(TiffinCustomer.class, customerID);
            } else {
                Query query = em.createNativeQuery(QueryConstant.GET_USER_BY_MOBILE_NUMBER, TiffinCustomer.class)
                        .setParameter("smsPhone", new BigInteger(mobileNumber));
                tiffinCustomer = (TiffinCustomer) query.getSingleResult();
                String tpin = TiffinStringUtils.createTpin(5);
                tiffinCustomer.setTpin(tpin);
                tiffinCustomer.setTpinCount(tiffinCustomer.getTpinCount() + 1);
            }
            if (tiffinCustomer != null) {
                if (tiffinCustomer.getTpinCount() > 3) {
                    String tpin = TiffinStringUtils.createTpin(5);
                    tiffinCustomer.setTpin(tpin);
                    tiffinCustomer.setTpinCount(tiffinCustomer.getTpinCount() + 1);
                    em.merge(tiffinCustomer);
                }

                SmsDTO smsDTO = createSMSDTO(tiffinCustomer);
                smsHelper.sendSMS(smsDTO);
                messageDTO.setCustomerID(tiffinCustomer.getCustomerID().toString());
                messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
                messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
            } else {
                messageDTO.setMessageID(MsgConstant.FAILURE_ID);
                messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
            }
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    @Override
    public MessageDTO getAddress(Integer customerID) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            Query query = em.createNativeQuery(QueryConstant.GET_ADDRESS_BY_USER_ID, AddressMaster.class)
                    .setParameter("custID", customerID);
            List<AddressMaster> addressMasters = query.getResultList();
            List<AddressMasterDTO> addressMasterDTOs = new ArrayList<AddressMasterDTO>();
            for (AddressMaster addressMaster : addressMasters) {
                AddressMasterDTO addressMasterDTO = mapAddressMasterDTO(addressMaster);
                addressMasterDTOs.add(addressMasterDTO);
            }
            messageDTO.setAddresses(addressMasterDTOs);
            messageDTO.setMessageID(AppMsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(AppMsgConstant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            messageDTO.setMessageID(AppMsgConstant.FAILURE_ID);
            messageDTO.setMessageText(AppMsgConstant.FAILURE_MESSAGE);
        }
        return messageDTO;
    }

    @Override
    public MessageDTO rechargeAccount(Integer customerID, String rechargeAmount, String rechargeStatus, String rechargeMode,
            String ipAddress) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            Recharge recharge = new Recharge();
            recharge.setRechargeDate(TiffinDateUtils.getCurrentDate());
            recharge.setUserID(customerID);
            recharge.setRechargeAmount(new BigDecimal(rechargeAmount));
            recharge.setRechargeMode(rechargeMode);
            recharge.setRechargeStatus(rechargeStatus);
            recharge.setIpAddress(ipAddress);
            recharge.setCreatedDateTime(TiffinDateUtils.getCurrentDateAndTime());
            em.persist(recharge);

            messageDTO.setMessageID(AppMsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(AppMsgConstant.SUCCESS_MESSAGE);
            messageDTO.setRechargeID(recharge.getRechargeID().toString());
        } catch (Exception e) {
            messageDTO.setMessageID(AppMsgConstant.FAILURE_ID);
            messageDTO.setMessageText(AppMsgConstant.FAILURE_MESSAGE);
        }
        return messageDTO;
    }

    @Override
    public MessageDTO updateRechargeStatus(Integer rechargeID, String status) {
        MessageDTO messageDTO = new MessageDTO();

        try {
            Recharge recharge = em.find(Recharge.class, rechargeID);
            if (recharge != null) {
                recharge.setRechargeStatus(status);
                em.merge(recharge);
                messageDTO.setRechargeStatus(status);
//                Query query = em.createNativeQuery(QueryConstant.UPDATE_CUSTOMER_ACCOUNT_BALANCE)
//                        .setParameter("amount", recharge.getRechargeAmount())
//                        .setParameter("customerID", recharge.getUserID());
//                isUpdated = query.executeUpdate();
                TiffinCustomer tiffinCustomer = em.find(TiffinCustomer.class, recharge.getUserID());
                if (status.equals("C")) {
                    BigDecimal smallBiteWallet = tiffinCustomer.getSmallBiteWallet() != null
                            ? tiffinCustomer.getSmallBiteWallet().add(recharge.getRechargeAmount()) : BigDecimal.ZERO;
                    tiffinCustomer.setSmallBiteWallet(smallBiteWallet);
                    em.persist(tiffinCustomer);
                }
                messageDTO.setRechargeAmount(tiffinCustomer.getSmallBiteWallet().toString());
                messageDTO.setMessageID(AppMsgConstant.SUCCESS_ID);
                messageDTO.setMessageText(AppMsgConstant.SUCCESS_MESSAGE);
            } else {
                messageDTO.setMessageID(AppMsgConstant.FAILURE_ID);
                messageDTO.setMessageText(AppMsgConstant.FAILURE_MESSAGE);
            }
        } catch (Exception e) {
            messageDTO.setMessageID(AppMsgConstant.FAILURE_ID);
            messageDTO.setMessageText(AppMsgConstant.FAILURE_MESSAGE);
        }
        return messageDTO;
    }

    @Override
    public MessageDTO saveFeedback(Integer customerID, String feedback) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            CustomerFeedback customerFeedback = new CustomerFeedback();
            customerFeedback.setCustomerID(customerID);
            customerFeedback.setFeedback(feedback);
            customerFeedback.setFeedbackDate(TiffinDateUtils.getCurrentDate());
            em.persist(customerFeedback);
            messageDTO.setMessageID(AppMsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(AppMsgConstant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            messageDTO.setMessageID(AppMsgConstant.FAILURE_ID);
            messageDTO.setMessageText(AppMsgConstant.FAILURE_MESSAGE);
        }
        return messageDTO;
    }

    @Override
    public MessageDTO getWalletBalance(Integer customerID) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            TiffinCustomer customer = em.find(TiffinCustomer.class, customerID);
            if (customer.getSmallBiteWallet() != null) {
                messageDTO.setRechargeAmount(customer.getSmallBiteWallet().toString());
            } else {
                messageDTO.setRechargeAmount(TiffinSysConstant.EMPTY_STRING);
            }
            messageDTO.setMessageID(AppMsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(AppMsgConstant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            messageDTO.setMessageID(AppMsgConstant.FAILURE_ID);
            messageDTO.setMessageID(AppMsgConstant.FAILURE_MESSAGE);
        }
        return messageDTO;
    }

    @Override
    public MessageDTO sendBulkSMS(String smsText) {
        MessageDTO messageDTO = new MessageDTO();
        try {

            messageDTO.setMessageID(AppMsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(AppMsgConstant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            messageDTO.setMessageID(AppMsgConstant.FAILURE_ID);
            messageDTO.setMessageText(AppMsgConstant.FAILURE_MESSAGE);
        }
        return messageDTO;
    }

    @Override
    public MessageDTO updateLocality(Integer customerID, Integer localityID) {
        MessageDTO messageDTO = new MessageDTO();
        Query query = em.createNativeQuery(QueryConstant.UPDATE_LOCALITY_INTO_CUSTOMER_BY_ID)
                .setParameter("localityID", localityID)
                .setParameter("customerID", customerID);
        int rowsUpdate = query.executeUpdate();
        if (rowsUpdate > 0) {
            messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
        } else {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }
}
