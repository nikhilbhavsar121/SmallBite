package com.rebindtech.tiffin.dto;

import java.util.List;

/**
 *
 * @author Sagar
 */
public class SupplierDTO {

    private String supplierID;
    private String supplierName;
    public String outletName;
    private String addressLine1;
    private String addressLine2;
    private String locality;
    private String city;
    private String state;
    private String pincode;
    private String lattitude;
    private String longitude;
    private Boolean isLogoUploaded;
    private String ratings;
    private String ownerName;
    private String sMSPhone;
    private String email;
    private String sTDCode;
    private String landLine;
    private String lunchTimeStart;
    private String lunchTimeEnd;
    private String dinnerTimeStart;
    private String dinnerTimeEnd;
    private String deliveryTime;
    private String weeklyPackagePrice;
    private String monthlyPackagePrice;
    private String pricePerTiffin;
    private Boolean isVeg;
    private List<TiffinDTO> tiffins;

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Boolean isIsLogoUploaded() {
        return isLogoUploaded;
    }

    public void setIsLogoUploaded(Boolean isLogoUploaded) {
        this.isLogoUploaded = isLogoUploaded;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getsMSPhone() {
        return sMSPhone;
    }

    public void setsMSPhone(String sMSPhone) {
        this.sMSPhone = sMSPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getsTDCode() {
        return sTDCode;
    }

    public void setsTDCode(String sTDCode) {
        this.sTDCode = sTDCode;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getLunchTimeStart() {
        return lunchTimeStart;
    }

    public void setLunchTimeStart(String lunchTimeStart) {
        this.lunchTimeStart = lunchTimeStart;
    }

    public String getLunchTimeEnd() {
        return lunchTimeEnd;
    }

    public void setLunchTimeEnd(String lunchTimeEnd) {
        this.lunchTimeEnd = lunchTimeEnd;
    }

    public String getDinnerTimeStart() {
        return dinnerTimeStart;
    }

    public void setDinnerTimeStart(String dinnerTimeStart) {
        this.dinnerTimeStart = dinnerTimeStart;
    }

    public String getDinnerTimeEnd() {
        return dinnerTimeEnd;
    }

    public void setDinnerTimeEnd(String dinnerTimeEnd) {
        this.dinnerTimeEnd = dinnerTimeEnd;
    }

    public List<TiffinDTO> getTiffins() {
        return tiffins;
    }

    public void setTiffins(List<TiffinDTO> tiffins) {
        this.tiffins = tiffins;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getWeeklyPackagePrice() {
        return weeklyPackagePrice;
    }

    public void setWeeklyPackagePrice(String weeklyPackagePrice) {
        this.weeklyPackagePrice = weeklyPackagePrice;
    }

    public String getMonthlyPackagePrice() {
        return monthlyPackagePrice;
    }

    public void setMonthlyPackagePrice(String monthlyPackagePrice) {
        this.monthlyPackagePrice = monthlyPackagePrice;
    }

    public String getPricePerTiffin() {
        return pricePerTiffin;
    }

    public void setPricePerTiffin(String pricePerTiffin) {
        this.pricePerTiffin = pricePerTiffin;
    }

    public Boolean isIsVeg() {
        return isVeg;
    }

    public void setIsVeg(Boolean isVeg) {
        this.isVeg = isVeg;
    }

}
