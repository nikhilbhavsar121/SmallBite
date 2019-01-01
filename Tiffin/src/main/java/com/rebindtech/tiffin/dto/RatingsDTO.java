package com.rebindtech.tiffin.dto;

/**
 *
 * @author Sagar
 */
public class RatingsDTO {

    private String ratingID;
    private String tiffinSupplierID;
    private String customerID;
    private String isForService;
    private String ratings;
    private String comment;
    private Boolean isPublish;
    private String createdDateTime;

    public String getRatingID() {
        return ratingID;
    }

    public void setRatingID(String ratingID) {
        this.ratingID = ratingID;
    }

    public String getTiffinSupplierID() {
        return tiffinSupplierID;
    }

    public void setTiffinSupplierID(String tiffinSupplierID) {
        this.tiffinSupplierID = tiffinSupplierID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getIsForService() {
        return isForService;
    }

    public void setIsForService(String isForService) {
        this.isForService = isForService;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean isIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Boolean isPublish) {
        this.isPublish = isPublish;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
    

}
