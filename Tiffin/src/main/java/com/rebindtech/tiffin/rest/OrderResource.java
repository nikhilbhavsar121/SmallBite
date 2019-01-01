/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.rest;

import com.rebindtech.tiffin.ctrl.CtrlCollection;
import com.rebindtech.tiffin.ctrl.OrderCtrl;
import com.rebindtech.tiffin.dto.core.OrderDTO;
import com.rebindtech.tiffin.utils.JsonConverter;
import java.util.Arrays;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mrsagar
 */
@Path("order")
public class OrderResource extends AppResource {

    @Context
    private UriInfo context;

    OrderCtrl orderCtrl;

    /**
     * Creates a new instance of OrderResource
     */
    public OrderResource() {
        this.orderCtrl = CtrlCollection.ORDER_CTRL;
    }

    @POST
    @Path("/addOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public String addOrder(String addOrderJSON) {
        setHeaders();
        OrderDTO orderDTO = (OrderDTO) JsonConverter.fromJsonToDTO(addOrderJSON, OrderDTO.class);
        orderCtrl.setAppRequest(request);
        String addOrderResponse = orderCtrl.addTiffinOrder(orderDTO);
        return addOrderResponse;
    }

    @POST
    @Path("/changeStatus")
    @Produces(MediaType.APPLICATION_JSON)
    public String changeOrderStatus(@FormParam("orderID") String orderID, @FormParam("paymentStatus") String paymentStatus,
            @FormParam("isPayment") Boolean isPayment,@FormParam("paymentMode") String paymentMode,
            @FormParam("walletamount") String walletAmount) {
        setHeaders();
        orderCtrl.setAppRequest(request);
        String changeOrderStatusResponse = orderCtrl.changeOrderStatus(Integer.parseInt(orderID), paymentStatus,isPayment,
                paymentMode,walletAmount);
        return changeOrderStatusResponse;
    }

    @GET
    @Path("/getOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOrder(@QueryParam("customerID") Integer customerID,
            @QueryParam("startDate") String startDate,@QueryParam("endDate") String endDate) {
        setHeaders();
        orderCtrl.setAppRequest(request);
        String getOrderResponse = orderCtrl.getOrder(customerID,startDate,endDate);
        return getOrderResponse;
    }
}
