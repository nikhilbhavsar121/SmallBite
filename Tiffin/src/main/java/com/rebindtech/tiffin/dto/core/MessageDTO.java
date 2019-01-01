package com.rebindtech.tiffin.dto.core;

import com.rebindtech.tiffin.dto.AddOnsDTO;
import com.rebindtech.tiffin.dto.TiffinDTO;
import com.rebindtech.tiffin.dto.AddressMasterDTO;
import com.rebindtech.tiffin.dto.CustomerDTO;
import com.rebindtech.tiffin.dto.CustomerOrderDTO;
import com.rebindtech.tiffin.dto.SubsMenuDTO;
import com.rebindtech.tiffin.dto.SupplierDTO;
import java.util.List;

/**
 *
 * @author Sagar
 */
public class MessageDTO {

    public String messageID;
    public String messageText;
    public String orderID;
    public String customerID;
    public String rechargeID;
    public String rechargeAmount;
    private String subsMenuID;
    private String rechargeStatus;
    public CustomerDTO customer;
    public AddressMasterDTO address;
    public SupplierDTO supplier;
    public TiffinDTO tiffin;
    public List<SupplierDTO> suppliers;
    public List<OrderDTO> orders;
    public List<AddressMasterDTO> addresses;
    public List<SubsMenuDTO> subsMenus;
    public List<AddOnsDTO> addOns;
    public List<CustomerOrderDTO> myOrders;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public AddressMasterDTO getAddress() {
        return address;
    }

    public void setAddress(AddressMasterDTO address) {
        this.address = address;
    }

    public SupplierDTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDTO supplier) {
        this.supplier = supplier;
    }

    public String getSubsMenuID() {
        return subsMenuID;
    }

    public void setSubsMenuID(String subsMenuID) {
        this.subsMenuID = subsMenuID;
    }

    public TiffinDTO getTiffin() {
        return tiffin;
    }

    public void setTiffin(TiffinDTO tiffin) {
        this.tiffin = tiffin;
    }

    public List<SupplierDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public List<AddressMasterDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressMasterDTO> addresses) {
        this.addresses = addresses;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getRechargeID() {
        return rechargeID;
    }

    public void setRechargeID(String rechargeID) {
        this.rechargeID = rechargeID;
    }

    public String getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getRechargeStatus() {
        return rechargeStatus;
    }

    public void setRechargeStatus(String rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    public List<SubsMenuDTO> getSubsMenus() {
        return subsMenus;
    }

    public void setSubsMenus(List<SubsMenuDTO> subsMenus) {
        this.subsMenus = subsMenus;
    }

    public List<AddOnsDTO> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOnsDTO> addOns) {
        this.addOns = addOns;
    }

    public List<CustomerOrderDTO> getMyOrders() {
        return myOrders;
    }

    public void setMyOrders(List<CustomerOrderDTO> myOrders) {
        this.myOrders = myOrders;
    }

}
