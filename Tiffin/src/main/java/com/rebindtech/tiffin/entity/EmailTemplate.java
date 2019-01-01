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
import javax.validation.constraints.Size;

/**
 *
 * @author mrsagar
 */
@Entity
@Table(name = "EmailTemplate")
@NamedQueries({
    @NamedQuery(name = "EmailTemplate.findAll", query = "SELECT e FROM EmailTemplate e")})
public class EmailTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EmailTemplateID")
    private Integer emailTemplateID;
    @Column(name = "EmailSMSReasonID")
    private Integer emailSMSReasonID;
    @Size(max = 100)
    @Column(name = "EmailSubject")
    private String emailSubject;
    @Size(max = 4000)
    @Column(name = "EmailBody")
    private String emailBody;

    public EmailTemplate() {
    }

    public EmailTemplate(Integer emailTemplateID) {
        this.emailTemplateID = emailTemplateID;
    }

    public Integer getEmailTemplateID() {
        return emailTemplateID;
    }

    public void setEmailTemplateID(Integer emailTemplateID) {
        this.emailTemplateID = emailTemplateID;
    }

    public Integer getEmailSMSReasonID() {
        return emailSMSReasonID;
    }

    public void setEmailSMSReasonID(Integer emailSMSReasonID) {
        this.emailSMSReasonID = emailSMSReasonID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailTemplateID != null ? emailTemplateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailTemplate)) {
            return false;
        }
        EmailTemplate other = (EmailTemplate) object;
        if ((this.emailTemplateID == null && other.emailTemplateID != null) || (this.emailTemplateID != null && !this.emailTemplateID.equals(other.emailTemplateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.core.EmailTemplate[ emailTemplateID=" + emailTemplateID + " ]";
    }
    
}
