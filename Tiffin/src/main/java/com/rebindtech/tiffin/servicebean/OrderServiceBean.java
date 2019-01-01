/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.servicebean;

import com.rebindtech.tiffin.constants.AppMsgConstant;
import com.rebindtech.tiffin.constants.EmailSMSConstant;
import com.rebindtech.tiffin.constants.MsgConstant;
import com.rebindtech.tiffin.constants.QueryConstant;
import com.rebindtech.tiffin.constants.TiffinSysConstant;
import com.rebindtech.tiffin.customer.TiffinCustomer;
import com.rebindtech.tiffin.dto.OrderDetailsDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.dto.core.OrderDTO;
import com.rebindtech.tiffin.entity.TiffinOrder;
import com.rebindtech.tiffin.dto.TiffinMenuDTO;
import com.rebindtech.tiffin.dto.core.SmsDTO;
import com.rebindtech.tiffin.entity.OrderDetails;
import com.rebindtech.tiffin.entity.TiffinOrderMenu;
import com.rebindtech.tiffin.service.OrderService;
import com.rebindtech.tiffin.utils.TiffinDateUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author mrsagar
 */
@Stateless
public class OrderServiceBean implements OrderService {

    @PersistenceContext
    EntityManager em;

    @EJB
    SMSHelper smsHelper;

    @EJB
    DeviceNotificationHelper devicenotification;

    @Override
    public MessageDTO addTiffinOrder(OrderDTO orderDTO) {
        MessageDTO messageDTO = new MessageDTO();
//        List<OrderDTO> tiffinOrderDTOs = new ArrayList<OrderDTO>();
        try {
//            for (OrderDTO orderDTO : orderDTOs) {
            TiffinOrder tiffinOrder = mapTiffinOrder(orderDTO);
            final Integer custID = tiffinOrder.getUserID();
            if (StringUtils.isBlank(orderDTO.getOrderID())) {
                em.persist(tiffinOrder);
                if (orderDTO.getMenus() != null && !orderDTO.getMenus().isEmpty()) {
                    mapTiffinMenus(orderDTO.getMenus(), tiffinOrder.getOrderid());
                }
                if (orderDTO.getOrderDetails() != null && !orderDTO.getOrderDetails().isEmpty()) {
                    mapOrderDetais(orderDTO.getOrderDetails(), tiffinOrder);
                }
                messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
                messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
                messageDTO.setOrderID(tiffinOrder.getOrderid().toString());
                new Thread() {
                    @Override
                    public void run() {
                        TiffinCustomer tiffinCustomer = em.find(TiffinCustomer.class, custID);
                        devicenotification.sendByUserID(TiffinSysConstant.ADMIN_USER_ID, "we got new order from " + tiffinCustomer.getFullName(), "C");
                    }

                }.start();
            } else {
                em.merge(tiffinOrder);
                messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
                messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
            }
//                OrderDTO tiffinOrderDTO = mapTiffinOrderDTO(tiffinOrder);
//                tiffinOrderDTOs.add(tiffinOrderDTO);
//            }
//            messageDTO.setOrders(tiffinOrderDTOs);
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private TiffinOrder mapTiffinOrder(OrderDTO orderDTO) {
        TiffinOrder tiffinOrder;
        if (StringUtils.isNotBlank(orderDTO.getOrderID())) {
            tiffinOrder = em.find(TiffinOrder.class, Integer.parseInt(orderDTO.getOrderID()));
            if (tiffinOrder == null) {
                return null;
            }
        } else {
            tiffinOrder = new TiffinOrder();
            tiffinOrder.setCreatedDateTime(TiffinDateUtils.getCurrentDateAndTime());
        }
        tiffinOrder.setSupplierID(Integer.parseInt(orderDTO.getSupplierID()));
//        tiffinOrder.setTiffinID(Integer.parseInt(orderDTO.getTiffinID()));
        tiffinOrder.setUserID(Integer.parseInt(orderDTO.getUserID()));
        tiffinOrder.setAddressID(Integer.parseInt(orderDTO.getAddressID()));
        tiffinOrder.setOrderDate(TiffinDateUtils.getFormattedDate(orderDTO.getOrderDate()));
//        tiffinOrder.setUnitCount(Integer.parseInt(orderDTO.getUnitCount()));
        if (StringUtils.isNotBlank(orderDTO.getSmallBiteMoney())) {
            tiffinOrder.setSmallBiteMoney(new BigDecimal(orderDTO.getSmallBiteMoney()));
        }
        if (StringUtils.isNotBlank(orderDTO.getFinalGrossAmount())) {
            tiffinOrder.setFinalGrossAmount(new BigDecimal(orderDTO.getFinalGrossAmount()));
        }
        if (StringUtils.isNotBlank(orderDTO.getFinalGrossDiscount())) {
            tiffinOrder.setFinalGrossDiscount(new BigDecimal(orderDTO.getFinalGrossDiscount()));
        }
        if (StringUtils.isNotBlank(orderDTO.getPrmocodeID())) {
            tiffinOrder.setPromocodeID(Integer.parseInt(orderDTO.getPrmocodeID()));
        }
        if (StringUtils.isNotBlank(orderDTO.getPromoDiscount())) {
            tiffinOrder.setPromocodeDiscount(new BigDecimal(orderDTO.getPromoDiscount()));
        }
        tiffinOrder.setNetAmount(new BigDecimal(orderDTO.getNetAmount()));
        if (StringUtils.isNotBlank(orderDTO.getPaymentMode())) {
            tiffinOrder.setPaymentMode(orderDTO.getPaymentMode());
        } else {
            tiffinOrder.setPaymentMode("CSH");
        }
        tiffinOrder.setPaymentStatus("P");
        return tiffinOrder;
    }

    private OrderDTO mapTiffinOrderDTO(TiffinOrder tiffinOrder) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderID(tiffinOrder.getOrderid().toString());
        orderDTO.setOrderDate(TiffinDateUtils.getFormattedDateString(tiffinOrder.getOrderDate()));
        orderDTO.setPaymentMode(tiffinOrder.getPaymentMode());
        orderDTO.setPaymentStatus(tiffinOrder.getPaymentStatus());
        orderDTO.setNetAmount(tiffinOrder.getFinalGrossAmount().toString());
        orderDTO.setIsLunch(tiffinOrder.getIsLunch());
//        List<OrderDetails> orderDetailses = tiffinOrder.getOrderDetailsList();
        List<OrderDetailsDTO> detailsDTOs = new ArrayList<OrderDetailsDTO>();
//        if (!orderDetailses.isEmpty()) {
//            detailsDTOs = createOrderDetailsDTO(orderDetailses);
        orderDTO.setOrderDetails(detailsDTOs);
//        }
        return orderDTO;
    }

    private void mapTiffinMenus(List<TiffinMenuDTO> menus, Integer orderid) {
        for (TiffinMenuDTO menuDTO : menus) {
            TiffinOrderMenu orderMenu = new TiffinOrderMenu();
            orderMenu.setTiffinID(orderid);
            orderMenu.setTiffinMenuID(Integer.parseInt(menuDTO.getTiffinMenuID()));
            if (StringUtils.isNotBlank(menuDTO.getQuantity())) {
                orderMenu.setQuantity(Integer.parseInt(menuDTO.getQuantity()));
            }
            em.persist(orderMenu);
        }
    }

    @Override
    public MessageDTO changeOrderStatus(Integer orderID, String paymentStatus, final Boolean isPayment,
            String paymentMode, String walletAmount) {
        MessageDTO messageDTO = new MessageDTO();
        final Integer customerID;
        BigDecimal smallBiteWallet = BigDecimal.ZERO;
        String previousStatus = TiffinSysConstant.EMPTY_STRING;
        try {
            TiffinOrder tiffinOrder = em.find(TiffinOrder.class, orderID);
            previousStatus = tiffinOrder.getPaymentStatus();
            final BigDecimal netAmount = tiffinOrder.getFinalGrossAmount();
            final Integer iOrderID = tiffinOrder.getOrderid();
            customerID = tiffinOrder.getUserID();
            tiffinOrder.setPaymentStatus(paymentStatus);
            if (StringUtils.isNotBlank(paymentMode)) {
                tiffinOrder.setPaymentMode(paymentMode);
            }

            TiffinCustomer customer = em.find(TiffinCustomer.class, tiffinOrder.getUserID());
            final String orderStatus = getOrderStatus(paymentStatus, tiffinOrder.getPaymentMode());
            if (tiffinOrder.getSmallBiteMoney() != null && (tiffinOrder.getSmallBiteMoney().compareTo(BigDecimal.ZERO) == 1)
                    && (previousStatus.equals("C") || paymentStatus.equals("C"))) {
                smallBiteWallet = updateCustomerWalletBalance(tiffinOrder.getUserID(), tiffinOrder.getSmallBiteMoney(), paymentStatus,
                        customer);
                messageDTO.setRechargeAmount(smallBiteWallet.toString());
            } else if (paymentStatus.equals("X")) {
                smallBiteWallet = updateCustomerWalletBalance(tiffinOrder.getUserID(), tiffinOrder.getFinalGrossAmount().subtract(tiffinOrder.getFinalGrossDiscount()),
                        paymentStatus, customer);
                messageDTO.setRechargeAmount(smallBiteWallet.toString());
            }
            sendOrderPlacedSMS(tiffinOrder, isPayment, customer);
//            new Thread() {
//                @Override
//                public void run() {
//                    if (isPayment != null && isPayment) {
//                        devicenotification.sendByUserID(customerID, "Thank you for the payment of Rs." + netAmount.toString()
//                                + " for order #" + iOrderID.toString(), "C");
//                    } else {
//                        devicenotification.sendByUserID(customerID, "Your order is " + orderStatus, "C");
//                    }
//                }
//
//            }.start();
            em.merge(tiffinOrder);
            em.merge(customer);
            messageDTO.setMessageID(AppMsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(AppMsgConstant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            messageDTO.setMessageID(AppMsgConstant.FAILURE_ID);
            messageDTO.setMessageText(AppMsgConstant.FAILURE_MESSAGE);
        }
        return messageDTO;
    }

    private void sendOrderPlacedSMS(TiffinOrder tiffinOrder, Boolean isPayment, TiffinCustomer tiffinCustomer) {
        try {
//            TiffinCustomer tiffinCustomer = em.find(TiffinCustomer.class, tiffinOrder.getUserID());
            SmsDTO smsDTO = createSMSDTO(tiffinCustomer);
            if (isPayment != null && isPayment) {
                smsDTO.setSmsReasonID(EmailSMSConstant.PAYMENT_STATUS_EMAIL_SMS_REASON_ID);
            }
            String orderStatus = getOrderStatus(tiffinOrder.getPaymentStatus(), tiffinOrder.getPaymentMode());
            smsDTO.setOrderStatus(orderStatus);
            smsDTO.setOrderNo(tiffinOrder.getOrderid().toString());
            smsDTO.setOrderAmount(tiffinOrder.getFinalGrossAmount().toString());
            if (!tiffinOrder.getPaymentStatus().equals("F")) {
                smsHelper.sendSMS(smsDTO);
            }
        } catch (Exception e) {
        }
    }

    private SmsDTO createSMSDTO(TiffinCustomer tiffinCustomer) {
        SmsDTO smsDTO = new SmsDTO();
        smsDTO.setReceiverID(tiffinCustomer.getCustomerID());
        smsDTO.setReceiverName(tiffinCustomer.getFullName());
        smsDTO.setAuthToken(tiffinCustomer.getTpin());
        smsDTO.setSmsNumber(tiffinCustomer.getSMSPhone());
        smsDTO.setSmsReasonID(EmailSMSConstant.ORDER_STATUS_EMAIL_SMS_REASON_ID);
        return smsDTO;
    }

    @Override
    public MessageDTO getOrder(Integer customerID, String startDate, String endDate) {
        MessageDTO messageDTO = new MessageDTO();
        List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
        Date dStartDate = TiffinDateUtils.getFormattedDate(startDate);
        Date dEndDate = TiffinDateUtils.getFormattedDate(endDate);
        try {
            Query query = em.createNativeQuery(QueryConstant.GET_ORDERS_BY_USER_ID_AND_BETWEEN_DATES, TiffinOrder.class)
                    .setParameter("userID", customerID)
                    .setParameter("startDate", dStartDate)
                    .setParameter("endDate", dEndDate);
            List<TiffinOrder> tiffinOrders = query.getResultList();
            for (TiffinOrder tiffinOrder : tiffinOrders) {
                OrderDTO orderDTO = mapTiffinOrderDTO(tiffinOrder);
                orderDTOs.add(orderDTO);
            }
            messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
            messageDTO.setOrders(orderDTOs);
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private String getOrderStatus(String paymentStatus, String paymentMode) {
        if (paymentStatus.equals("C") || (paymentMode.equals("CSH") && paymentStatus.equals("P"))) {
            return "Confirmed";
        } else {
            return "Cancelled";
        }
    }

    private BigDecimal updateCustomerWalletBalance(Integer userID, BigDecimal netAmount, String paymentStatus,
            TiffinCustomer customer) {
//        TiffinCustomer customer = em.find(TiffinCustomer.class, userID);
        BigDecimal creditAmount = customer.getSmallBiteWallet();
        if (paymentStatus.equals("C")) {
            creditAmount = customer.getSmallBiteWallet() != null
                    ? customer.getSmallBiteWallet().subtract(netAmount) : customer.getSmallBiteWallet();
        } else if (paymentStatus.equals("X")) {
            creditAmount = customer.getSmallBiteWallet() != null
                    ? customer.getSmallBiteWallet().add(netAmount) : customer.getSmallBiteWallet();
        }
        customer.setSmallBiteWallet(creditAmount);

        return creditAmount;
    }

    private List<OrderDetailsDTO> createOrderDetailsDTO(List<OrderDetails> orderDetailses) {
        List<OrderDetailsDTO> orderDetailsDTOs = new ArrayList<OrderDetailsDTO>();
        for (OrderDetails orderDetails : orderDetailses) {
            OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
            orderDetailsDTO.setOrderDetailsID(orderDetails.getOrderDetailsID().toString());
            orderDetailsDTO.setOrderID(orderDetails.getOrderID().getOrderid().toString());
            orderDetailsDTO.setTiffinCount(orderDetails.getTiffinCount().toString());
            orderDetailsDTO.setTiffinCost(orderDetails.getTiffinCost().toString());
            if (orderDetails.getAddOnID() != null) {
                orderDetailsDTO.setAddOnID(orderDetails.getAddOnID().toString());
            } else {
                orderDetailsDTO.setAddOnID(TiffinSysConstant.EMPTY_STRING);
            }
            if (orderDetails.getAddOnCost() != null) {
                orderDetailsDTO.setAddOnCost(orderDetails.getAddOnCost().toString());
            } else {
                orderDetailsDTO.setAddOnCost(TiffinSysConstant.EMPTY_STRING);
            }
            if (orderDetails.getAddOnCount() != null) {
                orderDetailsDTO.setAddOnCount(orderDetails.getAddOnCount().toString());
            } else {
                orderDetailsDTO.setAddOnCount(TiffinSysConstant.EMPTY_STRING);
            }
            orderDetailsDTOs.add(orderDetailsDTO);
        }
        return orderDetailsDTOs;
    }

    private void mapOrderDetais(List<OrderDetailsDTO> orderDetails, TiffinOrder tiffinOrder) {
        for (OrderDetailsDTO detailsDTO : orderDetails) {
            OrderDetails details = new OrderDetails();;
            details.setOrderID(tiffinOrder);
            if (StringUtils.isNotBlank(detailsDTO.getTiffinID())) {
                details.setTiffinID(Integer.parseInt(detailsDTO.getTiffinID()));
            }
            if (StringUtils.isNotBlank(detailsDTO.getTiffinCost())) {
                details.setTiffinCost(new BigDecimal(detailsDTO.getTiffinCost()));
            }
            if (StringUtils.isNotBlank(detailsDTO.getTiffinCount())) {
                details.setTiffinCount(Integer.parseInt(detailsDTO.getTiffinCount()));
            }
            if (StringUtils.isNotBlank(detailsDTO.getAddOnID())) {
                details.setAddOnID(Integer.parseInt(detailsDTO.getAddOnID()));
            }
            if (StringUtils.isNotBlank(detailsDTO.getAddOnCount())) {
                details.setAddOnCount(Integer.parseInt(detailsDTO.getAddOnCount()));
            }
            if (StringUtils.isNotBlank(detailsDTO.getAddOnCost())) {
                details.setAddOnCost(new BigDecimal(detailsDTO.getAddOnCost()));
            }
            if (detailsDTO.getIsLunch() != null) {
                details.setIsLunch(details.getIsLunch());
            }
            em.persist(details);

        }
    }
}
