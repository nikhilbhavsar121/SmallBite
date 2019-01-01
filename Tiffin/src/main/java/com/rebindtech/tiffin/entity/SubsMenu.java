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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SubsMenu")
@NamedQueries({
    @NamedQuery(name = "SubsMenu.findAll", query = "SELECT s FROM SubsMenu s")})
public class SubsMenu implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SupplierID")
    private int supplierID;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SubsMenuID")
    private Integer subsMenuID;
    @Size(max = 45)
    @Column(name = "MenuItemName")
    private String menuItemName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PricePerUnit")
    private BigDecimal pricePerUnit;
    @Column(name = "IsCustomizable")
    private Boolean isCustomizable;
    @Column(name = "CreatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "subsMenuID", fetch = FetchType.LAZY)
    private List<TiffinMenu> tiffinMenuList;
    @JoinColumn(name = "MenuCategoryID", referencedColumnName = "MenuCategoryID")
    @ManyToOne(fetch = FetchType.LAZY)
    private MenuCategory menuCategoryID;

    public SubsMenu() {
    }

    public SubsMenu(Integer subsMenuID) {
        this.subsMenuID = subsMenuID;
    }

    public SubsMenu(Integer subsMenuID, int supplierID) {
        this.subsMenuID = subsMenuID;
        this.supplierID = supplierID;
    }

    public Integer getSubsMenuID() {
        return subsMenuID;
    }

    public void setSubsMenuID(Integer subsMenuID) {
        this.subsMenuID = subsMenuID;
    }


    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Boolean getIsCustomizable() {
        return isCustomizable;
    }

    public void setIsCustomizable(Boolean isCustomizable) {
        this.isCustomizable = isCustomizable;
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

    public MenuCategory getMenuCategoryID() {
        return menuCategoryID;
    }

    public void setMenuCategoryID(MenuCategory menuCategoryID) {
        this.menuCategoryID = menuCategoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subsMenuID != null ? subsMenuID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubsMenu)) {
            return false;
        }
        SubsMenu other = (SubsMenu) object;
        if ((this.subsMenuID == null && other.subsMenuID != null) || (this.subsMenuID != null && !this.subsMenuID.equals(other.subsMenuID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.core.SubsMenu[ subsMenuID=" + subsMenuID + " ]";
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

}
