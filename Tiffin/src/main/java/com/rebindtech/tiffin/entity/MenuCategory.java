/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rebindtech.tiffin.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author mrsagar
 */
@Entity
@Table(name = "MenuCategory")
@NamedQueries({
    @NamedQuery(name = "MenuCategory.findAll", query = "SELECT m FROM MenuCategory m")})
public class MenuCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MenuCategoryID")
    private Integer menuCategoryID;
    @Size(max = 15)
    @Column(name = "MenuCategoryName")
    private String menuCategoryName;
    @Column(name = "IsActive")
    private Boolean isActive;
    @Column(name = "CreatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "menuCategoryID", fetch = FetchType.LAZY)
    private List<SubsMenu> subsMenuList;

    public MenuCategory() {
    }

    public MenuCategory(Integer menuCategoryID) {
        this.menuCategoryID = menuCategoryID;
    }

    public Integer getMenuCategoryID() {
        return menuCategoryID;
    }

    public void setMenuCategoryID(Integer menuCategoryID) {
        this.menuCategoryID = menuCategoryID;
    }

    public String getMenuCategoryName() {
        return menuCategoryName;
    }

    public void setMenuCategoryName(String menuCategoryName) {
        this.menuCategoryName = menuCategoryName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<SubsMenu> getSubsMenuList() {
        return subsMenuList;
    }

    public void setSubsMenuList(List<SubsMenu> subsMenuList) {
        this.subsMenuList = subsMenuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuCategoryID != null ? menuCategoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuCategory)) {
            return false;
        }
        MenuCategory other = (MenuCategory) object;
        if ((this.menuCategoryID == null && other.menuCategoryID != null) || (this.menuCategoryID != null && !this.menuCategoryID.equals(other.menuCategoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.i2rtech.tiffin.entity.core.MenuCategory[ menuCategoryID=" + menuCategoryID + " ]";
    }
    
}
