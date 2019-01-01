/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jt
 */
@Entity
public class CustomerOrder implements Serializable {

    @Id
    private Integer Order_id;
    private Integer CustomerID;
    private Boolean IsFirstOrder;
    private Integer TiffinID;
    private String FullName;
    private BigInteger SMSPhone;
    private String AddressLine1;
    private String AddressLine2;
    private Integer Tiffins;
    private String PaymentMode;
    private BigDecimal Receivable;
    private String AddressTag;
    private String Locality;
    private String City;
    private String Lattitude;
    private String Longitude;

    public Integer getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Integer Order_id) {
        this.Order_id = Order_id;
    }

    public Integer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Integer CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Boolean getIsFirstOrder() {
        return IsFirstOrder;
    }

    public void setIsFirstOrder(Boolean IsFirstOrder) {
        this.IsFirstOrder = IsFirstOrder;
    }

   

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public BigInteger getSMSPhone() {
        return SMSPhone;
    }

    public void setSMSPhone(BigInteger SMSPhone) {
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

    public Integer getTiffins() {
        return Tiffins;
    }

    public void setTiffins(Integer Tiffins) {
        this.Tiffins = Tiffins;
    }

    public String getPaymentMode() {
        return PaymentMode;
    }

    public void setPaymentMode(String PaymentMode) {
        this.PaymentMode = PaymentMode;
    }

    public BigDecimal getReceivable() {
        return Receivable;
    }

    public void setReceivable(BigDecimal Receivable) {
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

    public Integer getTiffinID() {
        return TiffinID;
    }

    public void setTiffinID(Integer TiffinID) {
        this.TiffinID = TiffinID;
    }
    

}
