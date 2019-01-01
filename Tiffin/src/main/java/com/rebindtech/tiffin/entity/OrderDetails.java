/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jt
 */
@Entity
@Table(name = "OrderDetails")
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o")})
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OrderDetailsID")
    private Integer orderDetailsID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TiffinCost")
    private BigDecimal tiffinCost;
    @Column(name = "TiffinCount")
    private Integer tiffinCount;
    @Column(name = "AddOnCost")
    private BigDecimal addOnCost;
    @Column(name = "AddOnCount")
    private Integer addOnCount;
    @Column(name = "AddOnID")
    private Integer addOnID;
    @JoinColumn(name = "OrderID", referencedColumnName = "Order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TiffinOrder orderID;
    @Column(name = "TiffinID")
    private Integer tiffinID;
    @Column(name = "IsLunch")
    private Boolean isLunch;

    public OrderDetails() {
    }

    public OrderDetails(Integer orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public Integer getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(Integer orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public BigDecimal getTiffinCost() {
        return tiffinCost;
    }

    public void setTiffinCost(BigDecimal tiffinCost) {
        this.tiffinCost = tiffinCost;
    }

    public Integer getTiffinCount() {
        return tiffinCount;
    }

    public void setTiffinCount(Integer tiffinCount) {
        this.tiffinCount = tiffinCount;
    }

    public BigDecimal getAddOnCost() {
        return addOnCost;
    }

    public void setAddOnCost(BigDecimal addOnCost) {
        this.addOnCost = addOnCost;
    }

    public Integer getAddOnCount() {
        return addOnCount;
    }

    public void setAddOnCount(Integer addOnCount) {
        this.addOnCount = addOnCount;
    }

    public Integer getAddOnID() {
        return addOnID;
    }

    public void setAddOnID(Integer addOnID) {
        this.addOnID = addOnID;
    }

    public TiffinOrder getOrderID() {
        return orderID;
    }

    public void setOrderID(TiffinOrder orderID) {
        this.orderID = orderID;
    }

    public Integer getTiffinID() {
        return tiffinID;
    }

    public void setTiffinID(Integer tiffinID) {
        this.tiffinID = tiffinID;
    }

    public Boolean getIsLunch() {
        return isLunch;
    }

    public void setIsLunch(Boolean isLunch) {
        this.isLunch = isLunch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailsID != null ? orderDetailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.orderDetailsID == null && other.orderDetailsID != null) || (this.orderDetailsID != null && !this.orderDetailsID.equals(other.orderDetailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
	{
		
        return "com.rebindtech.tiffin.entity.OrderDetails[ orderDetailsID=" + orderDetailsID + " ]";
    }

}
