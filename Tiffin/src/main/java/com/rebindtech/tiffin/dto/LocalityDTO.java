/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.dto;

/**
 *
 * @author Sagar
 */
public class LocalityDTO {

    private String localityID;
    private String localityName;
    private String deliveryCharges;
    private String supplierIDs;

    public String getLocalityID() {
        return localityID;
    }

    public void setLocalityID(String localityID) {
        this.localityID = localityID;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public String getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(String deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public String getSupplierIDs() {
        return supplierIDs;
    }

    public void setSupplierIDs(String supplierIDs) {
        this.supplierIDs = supplierIDs;
    }

}
