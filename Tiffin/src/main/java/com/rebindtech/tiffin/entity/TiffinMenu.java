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
 * @author mrsagar
 */
@Entity
@Table(name = "TiffinMenu")
@NamedQueries({
    @NamedQuery(name = "TiffinMenu.findAll", query = "SELECT t FROM TiffinMenu t")})
public class TiffinMenu implements Serializable {

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "IsDeleted")
    private Boolean isDeleted = false;
    @Column(name = "IsOptional")
    private Boolean isOptional = false;


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TiffinMenuID")
    private Integer tiffinMenuID;
    @JoinColumn(name = "TiffinID", referencedColumnName = "TiffinID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tiffin tiffinID;
    @JoinColumn(name = "SubsMenuID", referencedColumnName = "SubsMenuID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SubsMenu subsMenuID;

    public TiffinMenu() {
    }

    public TiffinMenu(Integer tiffinMenuID) {
        this.tiffinMenuID = tiffinMenuID;
    }

    public Integer getTiffinMenuID() {
        return tiffinMenuID;
    }

    public void setTiffinMenuID(Integer tiffinMenuID) {
        this.tiffinMenuID = tiffinMenuID;
    }

    public Tiffin getTiffinID() {
        return tiffinID;
    }

    public void setTiffinID(Tiffin tiffinID) {
        this.tiffinID = tiffinID;
    }

    public SubsMenu getSubsMenuID() {
        return subsMenuID;
    }

    public void setSubsMenuID(SubsMenu subsMenuID) {
        this.subsMenuID = subsMenuID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiffinMenuID != null ? tiffinMenuID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiffinMenu)) {
            return false;
        }
        TiffinMenu other = (TiffinMenu) object;
        if ((this.tiffinMenuID == null && other.tiffinMenuID != null) || (this.tiffinMenuID != null && !this.tiffinMenuID.equals(other.tiffinMenuID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.core.TiffinMenu[ tiffinMenuID=" + tiffinMenuID + " ]";
    }


    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean isIsOptional() {
        return isOptional;
    }

    public void setIsOptional(Boolean isOptional) {
        this.isOptional = isOptional;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
