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
@Table(name = "SMSReason")
@NamedQueries({
    @NamedQuery(name = "SMSReason.findAll", query = "SELECT s FROM SMSReason s")})
public class SMSReason implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SMSReasonID")
    private Integer sMSReasonID;
    @Size(max = 250)
    @Column(name = "SMSText")
    private String sMSText;

    public SMSReason() {
    }

    public SMSReason(Integer sMSReasonID) {
        this.sMSReasonID = sMSReasonID;
    }

    public Integer getSMSReasonID() {
        return sMSReasonID;
    }

    public void setSMSReasonID(Integer sMSReasonID) {
        this.sMSReasonID = sMSReasonID;
    }

    public String getSMSText() {
        return sMSText;
    }

    public void setSMSText(String sMSText) {
        this.sMSText = sMSText;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sMSReasonID != null ? sMSReasonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SMSReason)) {
            return false;
        }
        SMSReason other = (SMSReason) object;
        if ((this.sMSReasonID == null && other.sMSReasonID != null) || (this.sMSReasonID != null && !this.sMSReasonID.equals(other.sMSReasonID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.core.SMSReason[ sMSReasonID=" + sMSReasonID + " ]";
    }
    
}
