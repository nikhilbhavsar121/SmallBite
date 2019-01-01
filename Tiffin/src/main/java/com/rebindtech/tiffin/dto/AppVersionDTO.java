/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.dto;

/**
 *
 * @author mrsagar
 */
public class AppVersionDTO {

    public String appVersion;
    public Boolean isForceUpdate;

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Boolean getIsForceUpdate() {
        return isForceUpdate;
    }

    public void setIsForceUpdate(Boolean isForceUpdate) {
        this.isForceUpdate = isForceUpdate;
    }

}
