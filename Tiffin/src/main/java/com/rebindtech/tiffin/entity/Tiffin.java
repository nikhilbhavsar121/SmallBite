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
@Table(name = "Tiffin")
@NamedQueries({
    @NamedQuery(name = "Tiffin.findAll", query = "SELECT t FROM Tiffin t")})
public class Tiffin implements Serializable {

    @Size(max = 50)
    @Column(name = "TiffinName")
    private String tiffinName;
    @Size(max = 45)
    @Column(name = "ImageName")
    private String imageName;
    @OneToMany(mappedBy = "tiffinID", fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetailsList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TiffinID")
    private Integer tiffinID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SupplierID")
    private Integer supplierID;
    @Column(name = "TiffinDate")
    @Temporal(TemporalType.DATE)
    private Date tiffinDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TiffinCharges")
    private BigDecimal tiffinCharges;
    @Column(name = "IsRecurring")
    private Boolean isRecurring;
    @Column(name = "DayOfWeek")
    private Short dayOfWeek;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Column(name = "IsLunch")
    private Boolean isLunch;
    @Column(name = "IsVeg")
    private Boolean isVeg;
    @Column(name = "CreatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "tiffinID", fetch = FetchType.LAZY)
    private List<TiffinMenu> tiffinMenuList;

    public Tiffin() {
    }

    public Tiffin(Integer tiffinID) {
        this.tiffinID = tiffinID;
    }

    public Tiffin(Integer tiffinID, int supplierID) {
        this.tiffinID = tiffinID;
        this.supplierID = supplierID;
    }

    public Integer getTiffinID() {
        return tiffinID;
    }

    public void setTiffinID(Integer tiffinID) {
        this.tiffinID = tiffinID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public Date getTiffinDate() {
        return tiffinDate;
    }

    public void setTiffinDate(Date tiffinDate) {
        this.tiffinDate = tiffinDate;
    }

    public BigDecimal getTiffinCharges() {
        return tiffinCharges;
    }

    public void setTiffinCharges(BigDecimal tiffinCharges) {
        this.tiffinCharges = tiffinCharges;
    }

    public Boolean getIsRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    public Short getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Short dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsVeg() {
        return isVeg;
    }

    public void setIsVeg(Boolean isVeg) {
        this.isVeg = isVeg;
    }

    public Boolean isIsLunch() {
        return isLunch;
    }

    public void setIsLunch(Boolean isLunch) {
        this.isLunch = isLunch;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<TiffinMenu> getTiffinMenuList() {
        return tiffinMenuList;
    }

    public void setTiffinMenuList(List<TiffinMenu> tiffinMenuList) {
        this.tiffinMenuList = tiffinMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiffinID != null ? tiffinID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiffin)) {
            return false;
        }
        Tiffin other = (Tiffin) object;
        if ((this.tiffinID == null && other.tiffinID != null) || (this.tiffinID != null && !this.tiffinID.equals(other.tiffinID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.core.Tiffin[ tiffinID=" + tiffinID + " ]";
    }

    public String getTiffinName() {
        return tiffinName;
    }

    public void setTiffinName(String tiffinName) {
        this.tiffinName = tiffinName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
}
