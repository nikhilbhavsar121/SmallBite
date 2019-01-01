/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.dto;

import java.util.List;

/**
 *
 * @author jt
 */
public class CustomerOrderDTO {

    private String order_id;
    private String customerID;
    private Boolean isFirstOrder;
    private String TiffinName;
    private String FullName;
    private String SMSPhone;
    private String AddressLine1;
    private String AddressLine2;
    private String TiffinCount;
    private String PaymentMode;
    private String Receivable;
    private String AddressTag;
    private String Locality;
    private String City;
    private String Lattitude;
    private String Longitude;
    List<OrderDetailsDTO> orderDetails;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Boolean getIsFirstOrder() {
        return isFirstOrder;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getTiffinCount() {
        return TiffinCount;
    }

    public void setTiffinCount(String TiffinCount) {
        this.TiffinCount = TiffinCount;
    }

    public void setIsFirstOrder(Boolean isFirstOrder) {
        this.isFirstOrder = isFirstOrder;
    }

    public String getTiffinName() {
        return TiffinName;
    }

    public void setTiffinName(String TiffinName) {
        this.TiffinName = TiffinName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getSMSPhone() {
        return SMSPhone;
    }

    public void setSMSPhone(String SMSPhone) {
        this.SMSPhone = SMSPhone;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }

    public String getPaymentMode() {
        return PaymentMode;
    }

    public void setPaymentMode(String PaymentMode) {
        this.PaymentMode = PaymentMode;
    }

    public String getReceivable() {
        return Receivable;
    }

    public void setReceivable(String Receivable) {
        this.Receivable = Receivable;
    }

    public String getAddressTag() {
        return AddressTag;
    }

    public void setAddressTag(String AddressTag) {
        this.AddressTag = AddressTag;
    }

    public String getLocality() {
        return Locality;
    }

    public void setLocality(String Locality) {
        this.Locality = Locality;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getLattitude() {
        return Lattitude;
    }

    public void setLattitude(String Lattitude) {
        this.Lattitude = Lattitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    public List<OrderDetailsDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
