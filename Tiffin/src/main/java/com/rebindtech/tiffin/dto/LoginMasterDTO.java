package com.rebindtech.tiffin.dto;

/**
 *
 * @author Sagar
 */
public class LoginMasterDTO {

    private String loginMasterID;
    private String userID;
    private String privateDoor;
    private String privateChavi;
    private String lastLoginDateTime;
    private String lastLoginIpAddress;
    private String tpin;
    private String tpinSendDateTime;

    public String getLoginMasterID() {
        return loginMasterID;
    }

    public void setLoginMasterID(String loginMasterID) {
        this.loginMasterID = loginMasterID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPrivateDoor() {
        return privateDoor;
    }

    public void setPrivateDoor(String privateDoor) {
        this.privateDoor = privateDoor;
    }

    public String getPrivateChavi() {
        return privateChavi;
    }

    public void setPrivateChavi(String privateChavi) {
        this.privateChavi = privateChavi;
    }

    public String getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setLastLoginDateTime(String lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }

    public String getLastLoginIpAddress() {
        return lastLoginIpAddress;
    }

    public void setLastLoginIpAddress(String lastLoginIpAddress) {
        this.lastLoginIpAddress = lastLoginIpAddress;
    }

    public String getTpin() {
        return tpin;
    }

    public void setTpin(String tpin) {
        this.tpin = tpin;
    }

    public String getTpinSendDateTime() {
        return tpinSendDateTime;
    }

    public void setTpinSendDateTime(String tpinSendDateTime) {
        this.tpinSendDateTime = tpinSendDateTime;
    }

}
