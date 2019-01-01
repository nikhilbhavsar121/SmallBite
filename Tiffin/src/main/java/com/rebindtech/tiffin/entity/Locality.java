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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jt
 */
@Entity
@Table(name = "Locality")
@NamedQueries({
    @NamedQuery(name = "Locality.findAll", query = "SELECT l FROM Locality l WHERE l.isActive=1")})
public class Locality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LocalityID")
    private Integer localityID;
    @Size(max = 45)
    @Column(name = "LocalityName")
    private String localityName;
    @Size(max = 15)
    @Column(name = "SupplierIDs")
    private String supplierIDs;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DeliveryCharges")
    private BigDecimal deliveryCharges;
    @Column(name = "IsActive")
    private Boolean isActive = Boolean.TRUE;
    @JoinColumn(name = "CityID", referencedColumnName = "CityID")
    @ManyToOne(fetch = FetchType.LAZY)
    private City cityID;

    public Locality() {
    }

    public Locality(Integer localityID) {
        this.localityID = localityID;
    }

    public Integer getLocalityID() {
        return localityID;
    }

    public void setLocalityID(Integer localityID) {
        this.localityID = localityID;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public String getSupplierIDs() {
        return supplierIDs;
    }

    public void setSupplierIDs(String supplierIDs) {
        this.supplierIDs = supplierIDs;
    }

    public BigDecimal getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(BigDecimal deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localityID != null ? localityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locality)) {
            return false;
        }
        Locality other = (Locality) object;
        if ((this.localityID == null && other.localityID != null) || (this.localityID != null && !this.localityID.equals(other.localityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rebindtech.tiffin.entity.Locality[ localityID=" + localityID + " ]";
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
