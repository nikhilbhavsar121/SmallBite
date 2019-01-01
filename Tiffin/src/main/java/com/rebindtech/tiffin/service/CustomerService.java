package com.rebindtech.tiffin.service;

import com.rebindtech.tiffin.dto.AddressMasterDTO;
import com.rebindtech.tiffin.dto.CustomerDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import java.math.BigInteger;
import javax.ejb.Local;

/**
 *
 * @author Sagar
 */
@Local
public interface CustomerService {

    public MessageDTO verifyPin(Integer customerID, String pin, String type, Boolean isForget);

    public MessageDTO addAddress(AddressMasterDTO addressMasterDTO);

    public CustomerDTO getCustomer(Integer customerID);

    public MessageDTO addCustomer(Integer customerID, String fullName, String emailID, BigInteger mobileNumber, String password,
            String referralCode);

    public MessageDTO addDeviceID(Integer customerID, Integer deviceID);

    public MessageDTO reSendPin(Integer customerID, String mobileNumber);

    public MessageDTO getAddress(Integer customerID);

    public MessageDTO rechargeAccount(Integer customerID, String rechargeAmount, String rechargeStatus, String rechargeMode,
            String ipAddress);

    public MessageDTO updateRechargeStatus(Integer rechargeID, String status);

    public MessageDTO saveFeedback(Integer customerID, String feedback);

    public MessageDTO getWalletBalance(Integer customerID);

    public MessageDTO sendBulkSMS(String smsText);

    public MessageDTO updateLocality(Integer customerID, Integer localityID);

}
