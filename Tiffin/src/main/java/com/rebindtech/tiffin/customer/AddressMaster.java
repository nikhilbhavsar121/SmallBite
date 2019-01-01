/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.customer;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author mrsagar
 */
@Entity
@Table(name = "AddressMaster")
@NamedQueries({
    @NamedQuery(name = "AddressMaster.findAll", query = "SELECT a FROM AddressMaster a")})
public class AddressMaster implements Serializable {

    @Size(max = 45)
    @Column(name = "AddressTag")
    private String addressTag;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressMasterID")
    private Integer addressMasterID;
    @Size(max = 45)
    @Column(name = "AddressLine1")
    private String addressLine1;
    @Size(max = 45)
    @Column(name = "AddressLine2")
    private String addressLine2;
    @Size(max = 45)
    @Column(name = "Locality")
    private String locality;
    @Size(max = 45)
    @Column(name = "City")
    private String city;
    @Size(max = 45)
    @Column(name = "State")
    private String state;
    @Size(max = 45)
    @Column(name = "Pincode")
    private String pincode;
    @Size(max = 45)
    @Column(name = "Lattitude")
    private String lattitude;
    @Size(max = 45)
    @Column(name = "Longitude")
    private String longitude;
    @Column(name = "CreatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(fetch = FetchType.LAZY)
    private TiffinCustomer customerID;

    public AddressMaster() {
    }

    public AddressMaster(Integer addressMasterID) {
        this.addressMasterID = addressMasterID;
    }

    public Integer getAddressMasterID() {
        return addressMasterID;
    }

    public void setAddressMasterID(Integer addressMasterID) {
        this.addressMasterID = addressMasterID;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public TiffinCustomer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(TiffinCustomer customerID) {
        this.customerID = customerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressMasterID != null ? addressMasterID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressMaster)) {
            return false;
        }
        AddressMaster other = (AddressMaster) object;
        if ((this.addressMasterID == null && other.addressMasterID != null) || (this.addressMasterID != null && !this.addressMasterID.equals(other.addressMasterID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.customer.AddressMaster[ addressMasterID=" + addressMasterID + " ]";
    }

    public String getAddressTag() {
        return addressTag;
    }

    public void setAddressTag(String addressTag) {
        this.addressTag = addressTag;
    }

}
