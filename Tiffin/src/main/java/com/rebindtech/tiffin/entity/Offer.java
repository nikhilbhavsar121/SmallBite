/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author jt
 */
@Entity
@Table(name = "Offer")
@NamedQuery(name = "Offer.findAll", query = "SELECT a FROM Offer a WHERE a.isActive=1 "
        + " AND a.validUpto > DATE(now())")
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OfferID")
    private Integer offerID;
    @Column(name = "OfferDate")
    @Temporal(TemporalType.DATE)
    private Date offerDate;
    @Column(name = "ValidUpto")
    @Temporal(TemporalType.DATE)
    private Date validUpto;
    @Column(name = "OfferName")
    @Size(max = 45)
    private String offerName;
    @Column(name = "OfferCode")
    @Size(max = 10)
    private String offerCode;
    @Column(name = "ImageName")
    @Size(max = 45)
    private String imageName;
    @Column(name = "DiscountAmount")
    private BigDecimal discountAmount;
    @Column(name = "DiscountPerc")
    private Integer discountPerc;
    @Column(name = "MinPurchaseAmt")
    private BigDecimal minPurchaseAmt;
    @Column(name = "MaxCashbackAmt")
    private BigDecimal maxCashbackAmt;
    @Column(name = "IsActive")
    private Boolean isActive = Boolean.TRUE;

    public Integer getOfferID() {
        return offerID;
    }

    public void setOfferID(Integer offerID) {
        this.offerID = offerID;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public Date getValidUpto() {
        return validUpto;
    }

    public void setValidUpto(Date validUpto) {
        this.validUpto = validUpto;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getDiscountPerc() {
        return discountPerc;
    }

    public void setDiscountPerc(Integer discountPerc) {
        this.discountPerc = discountPerc;
    }

    public BigDecimal getMinPurchaseAmt() {
        return minPurchaseAmt;
    }

    public void setMinPurchaseAmt(BigDecimal minPurchaseAmt) {
        this.minPurchaseAmt = minPurchaseAmt;
    }

    public BigDecimal getMaxCashbackAmt() {
        return maxCashbackAmt;
    }

    public void setMaxCashbackAmt(BigDecimal maxCashbackAmt) {
        this.maxCashbackAmt = maxCashbackAmt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
