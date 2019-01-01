/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mrsagar
 */
@Entity
@Table(name = "TiffinOrder")
@NamedQueries({
    @NamedQuery(name = "TiffinOrder.findAll", query = "SELECT t FROM TiffinOrder t")})
public class TiffinOrder implements Serializable {

//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "TiffinID")
//    private Integer tiffinID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserID")
    private Integer userID;
    @Column(name = "SupplierID")
    private Integer supplierID;
    @Column(name = "UnitCount")
    private Integer unitCount;
    @Column(name = "PaymentStatus")
    private String paymentStatus;
    @Column(name = "OrderStatus")
    private String orderStatus;
    @OneToMany(mappedBy = "orderID", fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetailsList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Order_id")
    private Integer orderid;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FinalGrossAmount")
    private BigDecimal finalGrossAmount;
    @Column(name = "FinalGrossDiscount")
    private BigDecimal finalGrossDiscount;
    @Column(name = "NetAmount")
    private BigDecimal netAmount;
    @Column(name = "SmallBiteMoney")
    private BigDecimal smallBiteMoney;
    @Column(name = "PromocodeID")
    private Integer promocodeID;
    @Column(name = "AddressID")
    private Integer addressID;
    @Column(name = "PromocodeDiscount")
    private BigDecimal promocodeDiscount;
    @Size(max = 3)
    @Column(name = "PaymentMode")
    private String paymentMode;
    @Size(max = 45)
    @Column(name = "IpAddress")
    private String ipAddress;
    @Column(name = "CreatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @Column(name = "IsLunch")
    private Boolean isLunch=Boolean.TRUE;

    public TiffinOrder() {
    }

    public TiffinOrder(Integer orderid) {
        this.orderid = orderid;
    }

    public TiffinOrder(Integer orderid, Integer tiffinID, Integer userID) {
        this.orderid = orderid;
//        this.tiffinID = tiffinID;
        this.userID = userID;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public BigDecimal getFinalGrossAmount() {
        return finalGrossAmount;
    }

    public void setFinalGrossAmount(BigDecimal finalGrossAmount) {
        this.finalGrossAmount = finalGrossAmount;
    }

    public BigDecimal getFinalGrossDiscount() {
        return finalGrossDiscount;
    }

    public void setFinalGrossDiscount(BigDecimal finalGrossDiscount) {
        this.finalGrossDiscount = finalGrossDiscount;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getSmallBiteMoney() {
        return smallBiteMoney;
    }

    public void setSmallBiteMoney(BigDecimal smallBiteMoney) {
        this.smallBiteMoney = smallBiteMoney;
    }

    public Integer getPromocodeID() {
        return promocodeID;
    }

    public void setPromocodeID(Integer promocodeID) {
        this.promocodeID = promocodeID;
    }

    public BigDecimal getPromocodeDiscount() {
        return promocodeDiscount;
    }

    public void setPromocodeDiscount(BigDecimal promocodeDiscount) {
        this.promocodeDiscount = promocodeDiscount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
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
    public String toString() {
        return "com.i2rtech.tiffin.entity.core.TiffinOrder[ orderid=" + orderid + " ]";
    }

//    public Integer getTiffinID() {
//        return tiffinID;
//    }
//
//    public void setTiffinID(Integer tiffinID) {
//        this.tiffinID = tiffinID;
//    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public Boolean getIsLunch() {
        return isLunch;
    }

    public void setIsLunch(Boolean isLunch) {
        this.isLunch = isLunch;
    }

}
