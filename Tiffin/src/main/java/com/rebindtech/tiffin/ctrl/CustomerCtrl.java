package com.rebindtech.tiffin.ctrl;

import com.rebindtech.tiffin.dto.AddressMasterDTO;
import java.math.BigInteger;

/**
 *
 * @author Sagar
 */
public interface CustomerCtrl extends AuthenticationCtrl {

    public String verifyPin(Integer customerID, String pin, String type, Boolean isForget);

    public String addAddress(AddressMasterDTO addressMasterDTO);

    public String getCustomer(Integer customerID);

    public String addCustomer(Integer customerID, String fullName, String emailID, BigInteger mobileNumber, String password,
            String referralCode);

    public String addDeviceID(Integer customerID, Integer deviceID);

    public String reSendPin(Integer customerID, String mobileNumber);

    public String getAddress(Integer customerID);

    public String rechargeAccount(Integer customerID, String rechargeAmount, String rechargeStatus, String rechargeMode);

    public String updateRechargeStatus(Integer rechargeID, String status);

    public String saveFeedback(Integer customerID, String feedback);

    public String getWalletBalance(Integer customerID);

    public String sendBulkSMS(String smsText);

    public String updateLocality(Integer customerID, Integer localityID);

}
