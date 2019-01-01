/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.dto;

import java.util.List;

/**
 *
 * @author mrsagar
 */
public class TiffinDTO {

    public String tiffinID;
    public String supplierID;
    public String tiffinName;
    public String imageName;
    public String tiffinCharges;
    private String tiffinDate;
    private Boolean isLunch;
    private Boolean isVeg;
    public List<TiffinMenuDTO> menuItems;

    public String getTiffinID() {
        return tiffinID;
    }

    public void setTiffinID(String tiffinID) {
        this.tiffinID = tiffinID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getTiffinCharges() {
        return tiffinCharges;
    }

    public void setTiffinCharges(String tiffinCharges) {
        this.tiffinCharges = tiffinCharges;
    }

    public String getTiffinName() {
        return tiffinName;
    }

    public void setTiffinName(String tiffinName) {
        this.tiffinName = tiffinName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Boolean isIsLunch() {
        return isLunch;
    }

    public void setIsLunch(Boolean isLunch) {
        this.isLunch = isLunch;
    }

    public Boolean isIsVeg() {
        return isVeg;
    }

    public String getTiffinDate() {
        return tiffinDate;
    }

    public void setTiffinDate(String tiffinDate) {
        this.tiffinDate = tiffinDate;
    }

    public void setIsVeg(Boolean isVeg) {
        this.isVeg = isVeg;
    }

    public List<TiffinMenuDTO> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<TiffinMenuDTO> menuItems) {
        this.menuItems = menuItems;
    }

}
