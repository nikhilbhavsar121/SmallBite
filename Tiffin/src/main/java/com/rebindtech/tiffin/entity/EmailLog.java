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
@Table(name = "EmailLog")
@NamedQueries({
    @NamedQuery(name = "EmailLog.findAll", query = "SELECT e FROM EmailLog e")})
public class EmailLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EmailLogID")
    private Integer emailLogID;
    @Column(name = "CustomerID")
    private Integer customerID;
    @Column(name = "EmailSMSReasonID")
    private Integer emailSMSReasonID;
    @Size(max = 45)
    @Column(name = "FromEmailID")
    private String fromEmailID;
    @Size(max = 255)
    @Column(name = "ToEmailID")
    private String toEmailID;
    @Size(max = 255)
    @Column(name = "CcEmailID")
    private String ccEmailID;
    @Size(max = 100)
    @Column(name = "EmailSubject")
    private String emailSubject;
    @Size(max = 4000)
    @Column(name = "EmailBody")
    private String emailBody;
    @Column(name = "EmailScheduledDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emailScheduledDateTime;
    @Column(name = "EmailSentStatus")
    private Character emailSentStatus;
    @Column(name = "EmailSentStatusDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emailSentStatusDateTime;

    public EmailLog() {
    }

    public EmailLog(Integer emailLogID) {
        this.emailLogID = emailLogID;
    }

    public Integer getEmailLogID() {
        return emailLogID;
    }

    public void setEmailLogID(Integer emailLogID) {
        this.emailLogID = emailLogID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getEmailSMSReasonID() {
        return emailSMSReasonID;
    }

    public void setEmailSMSReasonID(Integer emailSMSReasonID) {
        this.emailSMSReasonID = emailSMSReasonID;
    }

    public String getFromEmailID() {
        return fromEmailID;
    }

    public void setFromEmailID(String fromEmailID) {
        this.fromEmailID = fromEmailID;
    }

    public String getToEmailID() {
        return toEmailID;
    }

    public void setToEmailID(String toEmailID) {
        this.toEmailID = toEmailID;
    }

    public String getCcEmailID() {
        return ccEmailID;
    }

    public void setCcEmailID(String ccEmailID) {
        this.ccEmailID = ccEmailID;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public Date getEmailScheduledDateTime() {
        return emailScheduledDateTime;
    }

    public void setEmailScheduledDateTime(Date emailScheduledDateTime) {
        this.emailScheduledDateTime = emailScheduledDateTime;
    }

    public Character getEmailSentStatus() {
        return emailSentStatus;
    }

    public void setEmailSentStatus(Character emailSentStatus) {
        this.emailSentStatus = emailSentStatus;
    }

    public Date getEmailSentStatusDateTime() {
        return emailSentStatusDateTime;
    }

    public void setEmailSentStatusDateTime(Date emailSentStatusDateTime) {
        this.emailSentStatusDateTime = emailSentStatusDateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailLogID != null ? emailLogID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailLog)) {
            return false;
        }
        EmailLog other = (EmailLog) object;
        if ((this.emailLogID == null && other.emailLogID != null) || (this.emailLogID != null && !this.emailLogID.equals(other.emailLogID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.core.EmailLog[ emailLogID=" + emailLogID + " ]";
    }
    
}
