/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.service;

import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.dto.core.OrderDTO;
import javax.ejb.Local;

/**
 *
 * @author mrsagar
 */
@Local
public interface OrderService {

    public MessageDTO addTiffinOrder(OrderDTO orderDTO);

    public MessageDTO changeOrderStatus(Integer orderID, String paymentStatus,Boolean isPayment,
            String paymentMode,String walletAmount);

    public MessageDTO getOrder(Integer customerID,String startDate,String endDate);

}
