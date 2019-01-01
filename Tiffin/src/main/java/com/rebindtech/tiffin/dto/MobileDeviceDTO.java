package com.rebindtech.tiffin.dto;

/**
 *
 * @author Govind
 */
public class MobileDeviceDTO {

    private Integer mobileDeviceID;
    private Integer customerID;
    private String deviceIMEI;
    private String deviceToken;
    private String appType;
    private String appVersion;

    public Integer getMobileDeviceID() {
        return mobileDeviceID;
    }

    public void setMobileDeviceID(Integer mobileDeviceID) {
        this.mobileDeviceID = mobileDeviceID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getDeviceIMEI() {
        return deviceIMEI;
    }

    public void setDeviceIMEI(String deviceIMEI) {
        this.deviceIMEI = deviceIMEI;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

}
