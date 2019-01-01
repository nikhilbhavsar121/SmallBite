/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.dto.core;

import com.rebindtech.tiffin.dto.OrderDetailsDTO;
import com.rebindtech.tiffin.dto.TiffinMenuDTO;
import java.util.List;

/**
 *
 * @author mrsagar
 */
public class OrderDTO {

    public String orderID;
    public String tiffinID;
    public String userID;
    public String supplierID;
    public String orderDate;
    public String unitCount;
    public Boolean isLunch;
    public String smallBiteMoney;
    public String finalGrossAmount;
    public String finalGrossDiscount;
    public String prmocodeID;
    public String promoDiscount;
    public String netAmount;
    public String paymentMode;
    public String paymentStatus;
    public String ipAddress;
    private String addressID;
    public String createdDateTime;
    List<TiffinMenuDTO> menus;
    List<OrderDetailsDTO> orderDetails;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getTiffinID() {
        return tiffinID;
    }

    public void setTiffinID(String tiffinID) {
        this.tiffinID = tiffinID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(String unitCount) {
        this.unitCount = unitCount;
    }

    public String getSmallBiteMoney() {
        return smallBiteMoney;
    }

    public void setSmallBiteMoney(String smallBiteMoney) {
        this.smallBiteMoney = smallBiteMoney;
    }

    public String getFinalGrossAmount() {
        return finalGrossAmount;
    }

    public void setFinalGrossAmount(String finalGrossAmount) {
        this.finalGrossAmount = finalGrossAmount;
    }

    public String getFinalGrossDiscount() {
        return finalGrossDiscount;
    }

    public void setFinalGrossDiscount(String finalGrossDiscount) {
        this.finalGrossDiscount = finalGrossDiscount;
    }

    public String getPrmocodeID() {
        return prmocodeID;
    }

    public void setPrmocodeID(String prmocodeID) {
        this.prmocodeID = prmocodeID;
    }

    public String getPromoDiscount() {
        return promoDiscount;
    }

    public void setPromoDiscount(String promoDiscount) {
        this.promoDiscount = promoDiscount;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<TiffinMenuDTO> getMenus() {
        return menus;
    }

    public void setMenus(List<TiffinMenuDTO> menus) {
        this.menus = menus;
    }

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    public List<OrderDetailsDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Boolean getIsLunch() {
        return isLunch;
    }

    public void setIsLunch(Boolean isLunch) {
        this.isLunch = isLunch;
    }

}
