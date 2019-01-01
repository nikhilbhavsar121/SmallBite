/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.dto;

/**
 *
 * @author jt
 */
public class OfferDTO {

    private String offerID;
    private String offerDate;
    private String validUpto;
    private String offerName;
    private String offerCode;
    private String imageName;
    private String discountAmount;
    private String discountPerc;
    private String minPurchaseAmt;
    private String maxCashbackAmt;
    private Boolean isActive;

    public String getOfferID() {
        return offerID;
    }

    public void setOfferID(String offerID) {
        this.offerID = offerID;
    }

    public String getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(String offerDate) {
        this.offerDate = offerDate;
    }

    public String getValidUpto() {
        return validUpto;
    }

    public void setValidUpto(String validUpto) {
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

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountPerc() {
        return discountPerc;
    }

    public void setDiscountPerc(String discountPerc) {
        this.discountPerc = discountPerc;
    }

    public String getMinPurchaseAmt() {
        return minPurchaseAmt;
    }

    public void setMinPurchaseAmt(String minPurchaseAmt) {
        this.minPurchaseAmt = minPurchaseAmt;
    }

    public String getMaxCashbackAmt() {
        return maxCashbackAmt;
    }

    public void setMaxCashbackAmt(String maxCashbackAmt) {
        this.maxCashbackAmt = maxCashbackAmt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
