/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author mrsagar
 */
@Entity
@Table(name = "LoginMaster")
@NamedQueries({
    @NamedQuery(name = "LoginMaster.findAll", query = "SELECT l FROM LoginMaster l")})
public class LoginMaster implements Serializable {

    @Size(max = 255)
    @Column(name = "AppDoorEmail")
    private String appDoorEmail;
    @Size(max = 40)
    @Column(name = "AppDoorKey")
    private String appDoorKey;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AppDoorPhone")
    private BigDecimal appDoorPhone;
    @Column(name = "CreatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Column(name = "CreatedPersonID")
    private Integer createdPersonID;
    @Size(max = 45)
    @Column(name = "IsActive")
    private String isActive;
    @Column(name = "LastUpdatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDateTime;
    @Column(name = "LastUpdatedPersonID")
    private Integer lastUpdatedPersonID;
    @Column(name = "PersonID")
    private Integer personID;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LoginMasterID")
    private Integer loginMasterID;
    @Column(name = "UserID")
    private Integer userID;
    @Column(name = "PrivateDoor")
    private BigInteger privateDoor;
    @Size(max = 45)
    @Column(name = "PrivateChavi")
    private String privateChavi;
    @Size(max = 45)
    @Column(name = "LastLoginDateTime")
    private String lastLoginDateTime;
    @Size(max = 45)
    @Column(name = "LastLoginIpAddress")
    private String lastLoginIpAddress;
    @Size(max = 45)
    @Column(name = "Tpin")
    private String tpin;
    @Size(max = 45)
    @Column(name = "TpinSendDateTime")
    private String tpinSendDateTime;

    public LoginMaster() {
    }

    public LoginMaster(Integer loginMasterID) {
        this.loginMasterID = loginMasterID;
    }

    public Integer getLoginMasterID() {
        return loginMasterID;
    }

    public void setLoginMasterID(Integer loginMasterID) {
        this.loginMasterID = loginMasterID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public BigInteger getPrivateDoor() {
        return privateDoor;
    }

    public void setPrivateDoor(BigInteger privateDoor) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginMasterID != null ? loginMasterID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoginMaster)) {
            return false;
        }
        LoginMaster other = (LoginMaster) object;
        if ((this.loginMasterID == null && other.loginMasterID != null) || (this.loginMasterID != null && !this.loginMasterID.equals(other.loginMasterID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.customer.LoginMaster[ loginMasterID=" + loginMasterID + " ]";
    }

    public String getAppDoorEmail() {
        return appDoorEmail;
    }

    public void setAppDoorEmail(String appDoorEmail) {
        this.appDoorEmail = appDoorEmail;
    }

    public String getAppDoorKey() {
        return appDoorKey;
    }

    public void setAppDoorKey(String appDoorKey) {
        this.appDoorKey = appDoorKey;
    }

    public BigDecimal getAppDoorPhone() {
        return appDoorPhone;
    }

    public void setAppDoorPhone(BigDecimal appDoorPhone) {
        this.appDoorPhone = appDoorPhone;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Integer getCreatedPersonID() {
        return createdPersonID;
    }

    public void setCreatedPersonID(Integer createdPersonID) {
        this.createdPersonID = createdPersonID;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Date getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    public Integer getLastUpdatedPersonID() {
        return lastUpdatedPersonID;
    }

    public void setLastUpdatedPersonID(Integer lastUpdatedPersonID) {
        this.lastUpdatedPersonID = lastUpdatedPersonID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }
    
}
