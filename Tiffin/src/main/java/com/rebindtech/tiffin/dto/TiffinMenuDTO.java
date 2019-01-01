/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.dto;

/**
 *
 * @author mrsagar
 */
public class TiffinMenuDTO {

    public String tiffinMenuID;
    public String quantity;
    public String menuCategoryID;
    public String menuItemname;
    public String pricePerUnit;
    public Boolean isCustomizable;
    public Boolean isOptional;
    private String tiffinID;
    private String subsMenuID;

    public String getTiffinMenuID() {
        return tiffinMenuID;
    }

    public void setTiffinMenuID(String tiffinMenuID) {
        this.tiffinMenuID = tiffinMenuID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMenuCategoryID() {
        return menuCategoryID;
    }

    public void setMenuCategoryID(String menuCategoryID) {
        this.menuCategoryID = menuCategoryID;
    }

    public String getMenuItemname() {
        return menuItemname;
    }

    public void setMenuItemname(String menuItemname) {
        this.menuItemname = menuItemname;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Boolean isIsQuantityChangeable() {
        return isCustomizable;
    }

    public void setIsCustomizable(Boolean isCustomizable) {
        this.isCustomizable = isCustomizable;
    }

    public Boolean isIsOptional() {
        return isOptional;
    }

    public void setIsOptional(Boolean isOptional) {
        this.isOptional = isOptional;
    }

    public String getTiffinID() {
        return tiffinID;
    }

    public void setTiffinID(String tiffinID) {
        this.tiffinID = tiffinID;
    }

    public String getSubsMenuID() {
        return subsMenuID;
    }

    public void setSubsMenuID(String subsMenuID) {
        this.subsMenuID = subsMenuID;
    }

}
