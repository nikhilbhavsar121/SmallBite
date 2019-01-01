/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.entity;

import java.io.Serializable;
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
@Table(name = "SMSLog")
@NamedQueries({
    @NamedQuery(name = "SMSLog.findAll", query = "SELECT s FROM SMSLog s")})
public class SMSLog implements Serializable {

    @Column(name = "SMSRoute")
    private String sMSRoute;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SMSLogID")
    private Integer sMSLogID;
    @Column(name = "CustomerID")
    private Integer customerID;
    @Size(max = 100)
    @Column(name = "ReceiverName")
    private String receiverName;
    @Column(name = "SMSNumber")
    private BigInteger sMSNumber;
    @Size(max = 6)
    @Column(name = "SMSSender")
    private String sMSSender;
    @Size(max = 500)
    @Column(name = "SMSText")
    private String sMSText;
    @Column(name = "SMSScheduledDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sMSScheduledDateTime;
    @Column(name = "SMSSentStatus")
    private Character sMSSentStatus;

    public SMSLog() {
    }

    public SMSLog(Integer sMSLogID) {
        this.sMSLogID = sMSLogID;
    }

    public Integer getSMSLogID() {
        return sMSLogID;
    }

    public void setSMSLogID(Integer sMSLogID) {
        this.sMSLogID = sMSLogID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public BigInteger getSMSNumber() {
        return sMSNumber;
    }

    public void setSMSNumber(BigInteger sMSNumber) {
        this.sMSNumber = sMSNumber;
    }

    public String getSMSSender() {
        return sMSSender;
    }

    public void setSMSSender(String sMSSender) {
        this.sMSSender = sMSSender;
    }

    public String getSMSText() {
        return sMSText;
    }

    public void setSMSText(String sMSText) {
        this.sMSText = sMSText;
    }


    public Date getSMSScheduledDateTime() {
        return sMSScheduledDateTime;
    }

    public void setSMSScheduledDateTime(Date sMSScheduledDateTime) {
        this.sMSScheduledDateTime = sMSScheduledDateTime;
    }

    public Character getSMSSentStatus() {
        return sMSSentStatus;
    }

    public void setSMSSentStatus(Character sMSSentStatus) {
        this.sMSSentStatus = sMSSentStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sMSLogID != null ? sMSLogID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SMSLog)) {
            return false;
        }
        SMSLog other = (SMSLog) object;
        if ((this.sMSLogID == null && other.sMSLogID != null) || (this.sMSLogID != null && !this.sMSLogID.equals(other.sMSLogID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.core.SMSLog[ sMSLogID=" + sMSLogID + " ]";
    }

    public String getsMSRoute() {
        return sMSRoute;
    }

    public void setsMSRoute(String sMSRoute) {
        this.sMSRoute = sMSRoute;
    }

   

}
