package com.rebindtech.tiffin.dto;

import java.util.List;

/**
 *
 * @author Sagar
 */
public class CustomerDTO {

    private String customerID;
    private String fullName;
    private String sMSPhone;
    private String emailID;
    private String tpin;
    private String localityID;
    private Boolean isFreeDelivery;
    private String packagingType;
    private String smallBiteMoney;
    private String tpinSendDateTime;
    private String referralCode;
    private String mobileActivationDateTime;
    private String tCAcceptedDateTime;
    private String emailActivationDateTime;
    private String emailKeySendDateTime;
    private String emailKey;
    private String createdDateTime;
    private List<AddressMasterDTO> addressList;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getsMSPhone() {
        return sMSPhone;
    }

    public void setsMSPhone(String sMSPhone) {
        this.sMSPhone = sMSPhone;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getTpin() {
        return tpin;
    }

    public void setTpin(String tpin) {
        this.tpin = tpin;
    }

    public String getLocalityID() {
        return localityID;
    }

    public void setLocalityID(String localityID) {
        this.localityID = localityID;
    }

    public Boolean getIsFreeDelivery() {
        return isFreeDelivery;
    }

    public void setIsFreeDelivery(Boolean isFreeDelivery) {
        this.isFreeDelivery = isFreeDelivery;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }

    public String getSmallBiteMoney() {
        return smallBiteMoney;
    }

    public void setSmallBiteMoney(String smallBiteMoney) {
        this.smallBiteMoney = smallBiteMoney;
    }

    public String getTpinSendDateTime() {
        return tpinSendDateTime;
    }

    public void setTpinSendDateTime(String tpinSendDateTime) {
        this.tpinSendDateTime = tpinSendDateTime;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getMobileActivationDateTime() {
        return mobileActivationDateTime;
    }

    public void setMobileActivationDateTime(String mobileActivationDateTime) {
        this.mobileActivationDateTime = mobileActivationDateTime;
    }

    public String gettCAcceptedDateTime() {
        return tCAcceptedDateTime;
    }

    public void settCAcceptedDateTime(String tCAcceptedDateTime) {
        this.tCAcceptedDateTime = tCAcceptedDateTime;
    }

    public String getEmailActivationDateTime() {
        return emailActivationDateTime;
    }

    public void setEmailActivationDateTime(String emailActivationDateTime) {
        this.emailActivationDateTime = emailActivationDateTime;
    }

    public String getEmailKeySendDateTime() {
        return emailKeySendDateTime;
    }

    public void setEmailKeySendDateTime(String emailKeySendDateTime) {
        this.emailKeySendDateTime = emailKeySendDateTime;
    }

    public String getEmailKey() {
        return emailKey;
    }

    public void setEmailKey(String emailKey) {
        this.emailKey = emailKey;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<AddressMasterDTO> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressMasterDTO> addressList) {
        this.addressList = addressList;
    }

}
