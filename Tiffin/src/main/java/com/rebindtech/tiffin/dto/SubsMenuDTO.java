package com.rebindtech.tiffin.dto;

/**
 *
 * @author mrsagar
 */
public class SubsMenuDTO {

    private String subsMenuID;
    private String menuCategoryID;
    private String supplierID;
    private String menuItemName;
    private String pricePerUnit;
    private Boolean isCustomizable;
    

    public String getSubsMenuID() {
        return subsMenuID;
    }

    public void setSubsMenuID(String subsMenuID) {
        this.subsMenuID = subsMenuID;
    }

    public String getMenuCategoryID() {
        return menuCategoryID;
    }

    public void setMenuCategoryID(String menuCategoryID) {
        this.menuCategoryID = menuCategoryID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Boolean isIsCustomizable() {
        return isCustomizable;
    }

    public void setIsCustomizable(Boolean isCustomizable) {
        this.isCustomizable = isCustomizable;
    }

}
