package com.rebindtech.tiffin.ctrlimpl;

import com.rebindtech.tiffin.auth.Authentication;
import com.rebindtech.tiffin.constants.AppMsgConstant;
import com.rebindtech.tiffin.ctrl.CustomerCtrl;
import com.rebindtech.tiffin.dto.AddressMasterDTO;
import com.rebindtech.tiffin.dto.CustomerDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.service.CustomerService;
import com.rebindtech.tiffin.service.JNDIService;
import com.rebindtech.tiffin.utils.JsonConverter;
import java.math.BigInteger;

/**
 *
 * @author mrsagar
 */
public class CustomerCtrlImpl extends Authentication implements CustomerCtrl {

    CustomerService customerService = JNDIService.getCustomerService();

    @Override
    public String addCustomer(Integer customerID, String fullName, String emailID, BigInteger mobileNumber, String password,
            String referralCode) {
        MessageDTO messageDTO = customerService.addCustomer(customerID, fullName, emailID, mobileNumber, password,
                referralCode);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String verifyPin(Integer customerID, String pin, String type, Boolean isForget) {
        MessageDTO messageDTO = customerService.verifyPin(customerID, pin, type, isForget);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String addAddress(AddressMasterDTO addressMasterDTO) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = customerService.addAddress(addressMasterDTO);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String getCustomer(Integer customerID) {
        CustomerDTO customerDTO = customerService.getCustomer(customerID);
        return JsonConverter.createJsonFromDTO(customerDTO);
    }

    @Override
    public String addDeviceID(Integer customerID, Integer deviceID) {
        MessageDTO messageDTO = customerService.addDeviceID(customerID, deviceID);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String reSendPin(Integer customerID, String mobileNumber) {
        MessageDTO messageDTO = customerService.reSendPin(customerID, mobileNumber);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String getAddress(Integer customerID) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = customerService.getAddress(customerID);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String rechargeAccount(Integer customerID, String rechargeAmount, String rechargeStatus, String rechargeMode) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        String ipAddress = "";//getIPFromRequest(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = customerService.rechargeAccount(customerID, rechargeAmount, rechargeStatus, rechargeMode, ipAddress);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String updateRechargeStatus(Integer rechargeID, String status) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = customerService.updateRechargeStatus(rechargeID, status);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String saveFeedback(Integer customerID, String feedback) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = customerService.saveFeedback(customerID, feedback);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String getWalletBalance(Integer customerID) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = customerService.getWalletBalance(customerID);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String sendBulkSMS(String smsText) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = customerService.sendBulkSMS(smsText);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String updateLocality(Integer customerID, Integer localityID) {
        MessageDTO messageDTO = customerService.updateLocality(customerID, localityID);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

}
