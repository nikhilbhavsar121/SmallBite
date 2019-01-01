/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "CustomerFeedback")
@NamedQueries({
    @NamedQuery(name = "CustomerFeedback.findAll", query = "SELECT c FROM CustomerFeedback c")})
public class CustomerFeedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CustomerFeedbackID")
    private Integer customerFeedbackID;
    @Column(name = "CustomerID")
    private Integer customerID;
    @Column(name = "FeedbackDate")
    @Temporal(TemporalType.DATE)
    private Date feedbackDate;
    @Size(max = 250)
    @Column(name = "Feedback")
    private String feedback;

    public CustomerFeedback() {
    }

    public CustomerFeedback(Integer customerFeedbackID) {
        this.customerFeedbackID = customerFeedbackID;
    }

    public Integer getCustomerFeedbackID() {
        return customerFeedbackID;
    }

    public void setCustomerFeedbackID(Integer customerFeedbackID) {
        this.customerFeedbackID = customerFeedbackID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerFeedbackID != null ? customerFeedbackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerFeedback)) {
            return false;
        }
        CustomerFeedback other = (CustomerFeedback) object;
        if ((this.customerFeedbackID == null && other.customerFeedbackID != null) || (this.customerFeedbackID != null && !this.customerFeedbackID.equals(other.customerFeedbackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rebindtech.tiffin.entity.CustomerFeedback[ customerFeedbackID=" + customerFeedbackID + " ]";
    }

}
