/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.dto.core;

import java.math.BigInteger;

/**
 *
 * @author mrsagar
 */
public class SmsDTO {

    private String smsText;
    private BigInteger smsNumber;
    private String receiverName;
    private String routeType;
    private Integer receiverID;
    private Integer smsReasonID;
    private String authToken;
    private String orderNo;
    private String orderAmount;
    private String orderStatus;

    public String getSmsText() {
        return smsText;
    }

    public void setSmsText(String smsText) {
        this.smsText = smsText;
    }

    public BigInteger getSmsNumber() {
        return smsNumber;
    }

    public void setSmsNumber(BigInteger smsNumber) {
        this.smsNumber = smsNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public Integer getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(Integer receiverID) {
        this.receiverID = receiverID;
    }

    public Integer getSmsReasonID() {
        return smsReasonID;
    }

    public void setSmsReasonID(Integer smsReasonID) {
        this.smsReasonID = smsReasonID;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
