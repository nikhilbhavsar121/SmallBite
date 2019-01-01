package com.rebindtech.tiffin.dto;

/**
 *
 * @author Sagar
 */
public class OrderDetailsDTO {

    private String orderDetailsID;
    private String orderID;
    private String tiffinID;
    private String tiffinCost;
    private String tiffinCount;
    private String addOnID;
    private String addOnCost;
    private String addOnCount;
    private String tiffinName;
    private String addOnName;
    private Boolean isLunch;

    public String getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(String orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getTiffinID() {
        return tiffinID;
    }

    public void setTiffinID(String tiffinID) {
        this.tiffinID = tiffinID;
    }

    public String getTiffinCost() {
        return tiffinCost;
    }

    public void setTiffinCost(String tiffinCost) {
        this.tiffinCost = tiffinCost;
    }

    public String getTiffinCount() {
        return tiffinCount;
    }

    public void setTiffinCount(String tiffinCount) {
        this.tiffinCount = tiffinCount;
    }

    public String getAddOnID() {
        return addOnID;
    }

    public void setAddOnID(String addOnID) {
        this.addOnID = addOnID;
    }

    public String getAddOnCost() {
        return addOnCost;
    }

    public void setAddOnCost(String addOnCost) {
        this.addOnCost = addOnCost;
    }

    public String getAddOnCount() {
        return addOnCount;
    }

    public void setAddOnCount(String addOnCount) {
        this.addOnCount = addOnCount;
    }

    public String getTiffinName() {
        return tiffinName;
    }

    public void setTiffinName(String tiffinName) {
        this.tiffinName = tiffinName;
    }

    public String getAddOnName() {
        return addOnName;
    }

    public void setAddOnName(String addOnName) {
        this.addOnName = addOnName;
    }

    public Boolean getIsLunch() {
        return isLunch;
    }

    public void setIsLunch(Boolean isLunch) {
        this.isLunch = isLunch;
    }

}
