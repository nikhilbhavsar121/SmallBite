package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Recharge")
@NamedQueries({
    @NamedQuery(name = "Recharge.findAll", query = "SELECT r FROM Recharge r")})
public class Recharge implements Serializable {

    @Column(name = "RechargeStatus")
    private String rechargeStatus;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RechargeID")
    private Integer rechargeID;
    @Column(name = "UserID")
    private Integer userID;
    @Column(name = "RechargeDate")
    @Temporal(TemporalType.DATE)
    private Date rechargeDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RechargeAmount")
    private BigDecimal rechargeAmount;
    @Size(max = 3)
    @Column(name = "RechargeMode")
    private String rechargeMode;
    @Size(max = 45)
    @Column(name = "IpAddress")
    private String ipAddress;
    @Column(name = "CreatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    public Recharge() {
    }

    public Recharge(Integer rechargeID) {
        this.rechargeID = rechargeID;
    }

    public Integer getRechargeID() {
        return rechargeID;
    }

    public void setRechargeID(Integer rechargeID) {
        this.rechargeID = rechargeID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getRechargeDate() {
        return rechargeDate;
    }

    public void setRechargeDate(Date rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getRechargeMode() {
        return rechargeMode;
    }

    public void setRechargeMode(String rechargeMode) {
        this.rechargeMode = rechargeMode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rechargeID != null ? rechargeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recharge)) {
            return false;
        }
        Recharge other = (Recharge) object;
        if ((this.rechargeID == null && other.rechargeID != null) || (this.rechargeID != null && !this.rechargeID.equals(other.rechargeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rebindtech.tiffin.entity.Recharge[ rechargeID=" + rechargeID + " ]";
    }

    public String getRechargeStatus() {
        return rechargeStatus;
    }

    public void setRechargeStatus(String rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

}
