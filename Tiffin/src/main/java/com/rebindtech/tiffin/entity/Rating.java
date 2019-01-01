/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mrsagar
 */
@Entity
@Table(name = "Rating")
@NamedQueries({
    @NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r")})
public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RatingID")
    private Integer ratingID;
    @Size(max = 45)
    @Column(name = "TiffinSupplierID")
    private String tiffinSupplierID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CustomerID")
    private String customerID;
    @Size(max = 45)
    @Column(name = "RatingDateTime")
    private String ratingDateTime;
    @Size(max = 45)
    @Column(name = "IsForService")
    private String isForService;
    @Size(max = 45)
    @Column(name = "Ratings")
    private String ratings;
    @Size(max = 45)
    @Column(name = "Comment")
    private String comment;
    @Size(max = 45)
    @Column(name = "CreatedDateTime")
    private String createdDateTime;

    public Rating() {
    }

    public Rating(Integer ratingID) {
        this.ratingID = ratingID;
    }

    public Rating(Integer ratingID, String customerID) {
        this.ratingID = ratingID;
        this.customerID = customerID;
    }

    public Integer getRatingID() {
        return ratingID;
    }

    public void setRatingID(Integer ratingID) {
        this.ratingID = ratingID;
    }

    public String getTiffinSupplierID() {
        return tiffinSupplierID;
    }

    public void setTiffinSupplierID(String tiffinSupplierID) {
        this.tiffinSupplierID = tiffinSupplierID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getRatingDateTime() {
        return ratingDateTime;
    }

    public void setRatingDateTime(String ratingDateTime) {
        this.ratingDateTime = ratingDateTime;
    }

    public String getIsForService() {
        return isForService;
    }

    public void setIsForService(String isForService) {
        this.isForService = isForService;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingID != null ? ratingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.ratingID == null && other.ratingID != null) || (this.ratingID != null && !this.ratingID.equals(other.ratingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.customer.Rating[ ratingID=" + ratingID + " ]";
    }
    
}
