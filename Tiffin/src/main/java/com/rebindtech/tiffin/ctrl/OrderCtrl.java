/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.ctrl;

import com.rebindtech.tiffin.dto.core.OrderDTO;

/**
 *
 * @author mrsagar
 */
public interface OrderCtrl extends AuthenticationCtrl{

    public String addTiffinOrder(OrderDTO orderDTO);

    public String changeOrderStatus(Integer orderID, String paymentStatus,Boolean isPayment,String paymentMode,
            String walletAmount);

    public String getOrder(Integer customerID,String startDate,String endDate);

}
