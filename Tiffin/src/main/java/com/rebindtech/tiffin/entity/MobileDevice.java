/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author mrsagar
 */
@Entity
@Table(name = "MobileDevice")
@NamedQueries({
    @NamedQuery(name = "MobileDevice.findAll", query = "SELECT m FROM MobileDevice m")})
public class MobileDevice implements Serializable {

    @Column(name = "AppType")
    private String appType;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MobileDeviceID")
    private Integer mobileDeviceID;
    @Column(name = "CustomerID")
    private Integer customerID;
    @Size(max = 45)
    @Column(name = "AppVersion")
    private String appVersion;
    @Size(max = 25)
    @Column(name = "DeviceIMEI")
    private String deviceIMEI;
    @Size(max = 500)
    @Column(name = "DeviceToken")
    private String deviceToken;

    public MobileDevice() {
    }

    public MobileDevice(Integer mobileDeviceID) {
        this.mobileDeviceID = mobileDeviceID;
    }

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


    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mobileDeviceID != null ? mobileDeviceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MobileDevice)) {
            return false;
        }
        MobileDevice other = (MobileDevice) object;
        if ((this.mobileDeviceID == null && other.mobileDeviceID != null) || (this.mobileDeviceID != null && !this.mobileDeviceID.equals(other.mobileDeviceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.zchromo.entity.MobileDevice[ mobileDeviceID=" + mobileDeviceID + " ]";
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }
    
}
