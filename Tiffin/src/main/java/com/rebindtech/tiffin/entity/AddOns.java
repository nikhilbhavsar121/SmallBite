/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;

/**
 *
 * @author jt
 */
@Entity
@Table(name = "AddOns")
@NamedQueries({
    @NamedQuery(name = "AddOns.findAll", query = "SELECT a FROM AddOns a WHERE a.isActive=1")})
public class AddOns implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AddOnsID")
    private Integer addOnsID;
    @Size(max = 50)
    @Column(name = "AddOnsName")
    private String addOnsName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PricePerUnit")
    private BigDecimal pricePerUnit;
    @Size(max = 45)
    @Column(name = "ImageName")
    private String imageName;
    @Column(name = "Priority")
    private Integer priority;
    @Column(name = "IsActive")
    private Boolean isActive;
    @OneToMany(mappedBy = "addOnID", fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetailsList;

    public AddOns() {
    }

    public AddOns(Integer addOnsID) {
        this.addOnsID = addOnsID;
    }

    public Integer getAddOnsID() {
        return addOnsID;
    }

    public void setAddOnsID(Integer addOnsID) {
        this.addOnsID = addOnsID;
    }

    public String getAddOnsName() {
        return addOnsName;
    }

    public void setAddOnsName(String addOnsName) {
        this.addOnsName = addOnsName;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addOnsID != null ? addOnsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddOns)) {
            return false;
        }
        AddOns other = (AddOns) object;
        if ((this.addOnsID == null && other.addOnsID != null) || (this.addOnsID != null && !this.addOnsID.equals(other.addOnsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rebindtech.tiffin.entity.AddOns[ addOnsID=" + addOnsID + " ]";
    }
    
}
