/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.ctrlimpl;

import com.rebindtech.tiffin.auth.Authentication;
import com.rebindtech.tiffin.constants.AppMsgConstant;
import com.rebindtech.tiffin.ctrl.OrderCtrl;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.dto.core.OrderDTO;
import com.rebindtech.tiffin.service.JNDIService;
import com.rebindtech.tiffin.service.OrderService;
import com.rebindtech.tiffin.utils.JsonConverter;
import java.util.List;

/**
 *
 * @author mrsagar
 */
public class OrderCtrlImpl extends Authentication implements OrderCtrl {

    OrderService orderService = JNDIService.getOrderService();

    @Override
    public String addTiffinOrder(OrderDTO orderDTOs) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = orderService.addTiffinOrder(orderDTOs);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String changeOrderStatus(Integer orderID, String paymentStatus,Boolean isPayment,String paymentMode,
            String walletAmount) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = orderService.changeOrderStatus(orderID, paymentStatus,isPayment,paymentMode,walletAmount);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String getOrder(Integer customerID,String startDate,String endDate) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = orderService.getOrder(customerID,startDate,endDate);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

}
