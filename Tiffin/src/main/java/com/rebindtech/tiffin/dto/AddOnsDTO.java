package com.rebindtech.tiffin.dto;

/**
 *
 * @author Sagar
 */
public class AddOnsDTO {

    private String addOnsID;
    private String addOnsName;
    private String pricePerUnit;
    private String imageName;
    private String priority;

    public String getAddOnsID() {
        return addOnsID;
    }

    public void setAddOnsID(String addOnsID) {
        this.addOnsID = addOnsID;
    }

    public String getAddOnsName() {
        return addOnsName;
    }

    public void setAddOnsName(String addOnsName) {
        this.addOnsName = addOnsName;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}
