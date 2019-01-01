/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.customer;

import com.rebindtech.tiffin.entity.Recharge;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author mrsagar
 */
@Entity
@Table(name = "TiffinCustomer")
@NamedQueries({
    @NamedQuery(name = "TiffinCustomer.findAll", query = "SELECT t FROM TiffinCustomer t")})
public class TiffinCustomer implements Serializable {

    @Column(name = "TpinCount")
    private Integer tpinCount;
    @Column(name = "IsFirstOrder")
    private Boolean isFirstOrder;
    @Column(name = "LocalityID")
    private Integer localityID;
    @Column(name = "IsFreeDelivery")
    private Boolean isFreeDelivery;
    @Size(max = 2)
    @Column(name = "PackagingType")
    private String packagingType;
    @Column(name = "IsDND")
    private Boolean isDND;
    @Column(name = "LastUpdatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedTime;
    @OneToMany(mappedBy = "userID", fetch = FetchType.LAZY)
    private List<Recharge> rechargeList;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SmallBiteWallet")
    private BigDecimal smallBiteWallet = BigDecimal.ZERO;
    @Size(max = 10)
    @Column(name = "ReferralCode")
    private String referralCode;
    @Size(max = 10)
    @Column(name = "RefereeCode")
    private String refereeCode;
    @Size(max = 1000)
    @Column(name = "SupplierIDs")
    private String supplierIDs;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CustomerID")
    private Integer customerID;
    @Size(max = 100)
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "SMSPhone")
    private BigInteger sMSPhone;
    @Size(max = 250)
    @Column(name = "EmailID")
    private String emailID;
    @Size(max = 6)
    @Column(name = "Tpin")
    private String tpin;
    @Size(max = 25)
    @Column(name = "DeviceID")
    private String deviceID;
    @Size(max = 6)
    @Column(name = "EmailKey")
    private String emailKey;
    @Size(max = 250)
    @Column(name = "RequestedPassword")
    private String requestedPassword;
    @Column(name = "TpinSendDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tpinSendDateTime;
    @Column(name = "EmailKeySendDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emailKeySendDateTime;
    @Column(name = "MobileActivationDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mobileActivationDateTime;
    @Column(name = "EmailActivationDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emailActivationDateTime;
    @Column(name = "TCAcceptedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tCAcceptedDateTime;
    @Column(name = "CreatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "customerID", fetch = FetchType.LAZY)
    private List<AddressMaster> addressMasterList;

    public TiffinCustomer() {
    }

    public TiffinCustomer(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigInteger getSMSPhone() {
        return sMSPhone;
    }

    public void setSMSPhone(BigInteger sMSPhone) {
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

    public Date getTpinSendDateTime() {
        return tpinSendDateTime;
    }

    public void setTpinSendDateTime(Date tpinSendDateTime) {
        this.tpinSendDateTime = tpinSendDateTime;
    }

    public Date getMobileActivationDateTime() {
        return mobileActivationDateTime;
    }

    public void setMobileActivationDateTime(Date mobileActivationDateTime) {
        this.mobileActivationDateTime = mobileActivationDateTime;
    }

    public Date getTCAcceptedDateTime() {
        return tCAcceptedDateTime;
    }

    public void setTCAcceptedDateTime(Date tCAcceptedDateTime) {
        this.tCAcceptedDateTime = tCAcceptedDateTime;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<AddressMaster> getAddressMasterList() {
        return addressMasterList;
    }

    public void setAddressMasterList(List<AddressMaster> addressMasterList) {
        this.addressMasterList = addressMasterList;
    }

    public String getEmailKey() {
        return emailKey;
    }

    public void setEmailKey(String emailKey) {
        this.emailKey = emailKey;
    }

    public Date getEmailKeySendDateTime() {
        return emailKeySendDateTime;
    }

    public void setEmailKeySendDateTime(Date emailKeySendDateTime) {
        this.emailKeySendDateTime = emailKeySendDateTime;
    }

    public Date getEmailActivationDateTime() {
        return emailActivationDateTime;
    }

    public void setEmailActivationDateTime(Date emailActivationDateTime) {
        this.emailActivationDateTime = emailActivationDateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiffinCustomer)) {
            return false;
        }
        TiffinCustomer other = (TiffinCustomer) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.customer.TiffinCustomer[ customerID=" + customerID + " ]";
    }

    public String getSupplierIDs() {
        return supplierIDs;
    }

    public void setSupplierIDs(String supplierIDs) {
        this.supplierIDs = supplierIDs;
    }

    public BigDecimal getSmallBiteWallet() {
        return smallBiteWallet;
    }

    public void setSmallBiteWallet(BigDecimal smallBiteWallet) {
        this.smallBiteWallet = smallBiteWallet;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getRefereeCode() {
        return refereeCode;
    }

    public void setRefereeCode(String refereeCode) {
        this.refereeCode = refereeCode;
    }

    public BigInteger getsMSPhone() {
        return sMSPhone;
    }

    public void setsMSPhone(BigInteger sMSPhone) {
        this.sMSPhone = sMSPhone;
    }


    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public Date gettCAcceptedDateTime() {
        return tCAcceptedDateTime;
    }

    public void settCAcceptedDateTime(Date tCAcceptedDateTime) {
        this.tCAcceptedDateTime = tCAcceptedDateTime;
    }

    public String getRequestedPassword() {
        return requestedPassword;
    }

    public void setRequestedPassword(String requestedPassword) {
        this.requestedPassword = requestedPassword;
    }

    public Integer getTpinCount() {
        return tpinCount;
    }

    public void setTpinCount(Integer tpinCount) {
        this.tpinCount = tpinCount;
    }

    public Boolean getIsFirstOrder() {
        return isFirstOrder;
    }

    public void setIsFirstOrder(Boolean isFirstOrder) {
        this.isFirstOrder = isFirstOrder;
    }

    public Integer getLocalityID() {
        return localityID;
    }

    public void setLocalityID(Integer localityID) {
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

    public Boolean getIsDND() {
        return isDND;
    }

    public void setIsDND(Boolean isDND) {
        this.isDND = isDND;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public List<Recharge> getRechargeList() {
        return rechargeList;
    }

    public void setRechargeList(List<Recharge> rechargeList) {
        this.rechargeList = rechargeList;
    }

}
