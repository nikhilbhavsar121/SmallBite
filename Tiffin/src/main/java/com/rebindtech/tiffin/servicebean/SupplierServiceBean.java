package com.rebindtech.tiffin.servicebean;

import com.rebindtech.tiffin.constants.MsgConstant;
import com.rebindtech.tiffin.constants.QueryConstant;
import com.rebindtech.tiffin.constants.TiffinSysConstant;
import com.rebindtech.tiffin.dto.AddOnsDTO;
import com.rebindtech.tiffin.dto.CustomerOrderDTO;
import com.rebindtech.tiffin.dto.OrderDetailsDTO;
import com.rebindtech.tiffin.dto.SubsMenuDTO;
import com.rebindtech.tiffin.dto.SupplierDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.dto.TiffinDTO;
import com.rebindtech.tiffin.dto.TiffinMenuDTO;
import com.rebindtech.tiffin.dto.TiffinMenusDTO;
import com.rebindtech.tiffin.entity.AddOns;
import com.rebindtech.tiffin.entity.CustomerOrder;
import com.rebindtech.tiffin.entity.OrderDetails;
//import com.rebindtech.tiffin.entity.Rating_;
import com.rebindtech.tiffin.entity.SubsMenu;
import com.rebindtech.tiffin.entity.Tiffin;
import com.rebindtech.tiffin.entity.TiffinMenu;
import com.rebindtech.tiffin.supplier.TiffinSupplier;
import com.rebindtech.tiffin.service.SupplierService;
import com.rebindtech.tiffin.utils.TiffinDateUtils;
import com.rebindtech.tiffin.utils.TiffinStringUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class SupplierServiceBean implements SupplierService {

    @PersistenceContext
    EntityManager em;

    @Override
    public MessageDTO addSupplier(SupplierDTO supplierDTO) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            TiffinSupplier tiffinSupplier = mapTiffinSupplier(supplierDTO);
            if (tiffinSupplier != null) {
                if (StringUtils.isNotBlank(supplierDTO.getSupplierID())) {
                    em.merge(tiffinSupplier);
                    messageDTO.setMessageID(MsgConstant.UPDATE_SUCCESS_ID);
                    messageDTO.setMessageText(MsgConstant.UPDATE_SUCCESS_TEXT);
                } else {
                    em.persist(tiffinSupplier);
                    messageDTO.setMessageID(MsgConstant.INSERT_SUCCESS_ID);
                    messageDTO.setMessageText(MsgConstant.INSERT_SUCCESS_TEXT);
                }
                SupplierDTO supplier = mapSupplierDTO(tiffinSupplier);
                messageDTO.setSupplier(supplier);
            }
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private TiffinSupplier mapTiffinSupplier(SupplierDTO supplierDTO) {
        TiffinSupplier tiffinSupplier;
        if (StringUtils.isNotBlank(supplierDTO.getSupplierID())) {
            tiffinSupplier = em.find(TiffinSupplier.class, Integer.parseInt(supplierDTO.getSupplierID()));
            if (tiffinSupplier == null) {
                return null;
            }
        } else {
            tiffinSupplier = new TiffinSupplier();
            tiffinSupplier.setSMSPhone(new BigInteger(supplierDTO.getsMSPhone()));
            tiffinSupplier.setEmail(supplierDTO.getEmail());
        }
        tiffinSupplier.setOutletName(supplierDTO.getLocality() + " Outlet");
        tiffinSupplier.setAddressLine1(supplierDTO.getAddressLine1());
        tiffinSupplier.setAddressLine2(supplierDTO.getAddressLine2());
        tiffinSupplier.setLocality(supplierDTO.getLocality());
        tiffinSupplier.setCity(supplierDTO.getCity());
        tiffinSupplier.setState(supplierDTO.getState());
        tiffinSupplier.setPincode(supplierDTO.getPincode());
        tiffinSupplier.setSTDCode(supplierDTO.getsTDCode());
        tiffinSupplier.setLandLine(supplierDTO.getLandLine());
        tiffinSupplier.setLattitude(supplierDTO.getLattitude());
        tiffinSupplier.setLongitude(supplierDTO.getLongitude());
        tiffinSupplier.setOwenName(supplierDTO.getOwnerName());
        if (StringUtils.isNotBlank(supplierDTO.getLunchTimeStart())) {
            tiffinSupplier.setLunchTimeStart(TiffinDateUtils.getFormatedTimeHH_MMFromString(supplierDTO.getLunchTimeStart()));
        }
        if (StringUtils.isNotBlank(supplierDTO.getLunchTimeEnd())) {
            tiffinSupplier.setLunchTimeEnd(TiffinDateUtils.getFormatedTimeHH_MMFromString(supplierDTO.getLunchTimeEnd()));
        }
        if (StringUtils.isNotBlank(supplierDTO.getDinnerTimeStart())) {
            tiffinSupplier.setDinnerTimeStart(TiffinDateUtils.getFormatedTimeHH_MMFromString(supplierDTO.getDinnerTimeStart()));
        }
        if (StringUtils.isNotBlank(supplierDTO.getDinnerTimeEnd())) {
            tiffinSupplier.setDinnerTimeEnd(TiffinDateUtils.getFormatedTimeHH_MMFromString(supplierDTO.getDinnerTimeEnd()));
        }
        if (StringUtils.isNotBlank(supplierDTO.getDeliveryTime())) {
            tiffinSupplier.setDeliveryTime(supplierDTO.getDeliveryTime());
        }
        if (StringUtils.isNotBlank(supplierDTO.getPricePerTiffin())) {
            tiffinSupplier.setPerTiffinPrice(new BigDecimal(supplierDTO.getPricePerTiffin()));
        }
        if (StringUtils.isNotBlank(supplierDTO.getWeeklyPackagePrice())) {
            tiffinSupplier.setWeeklyPackagePrice(new BigDecimal(supplierDTO.getWeeklyPackagePrice()));
        }
        if (StringUtils.isNotBlank(supplierDTO.getMonthlyPackagePrice())) {
            tiffinSupplier.setMonthlyPackagePrice(new BigDecimal(supplierDTO.getMonthlyPackagePrice()));
        }
        if (supplierDTO.isIsVeg() != null) {
            tiffinSupplier.setIsVeg(supplierDTO.isIsVeg());
        }
        return tiffinSupplier;
    }

    private SupplierDTO mapSupplierDTO(TiffinSupplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSupplierID(supplier.getTiffinSupplierID().toString());
        supplierDTO.setSupplierName(supplier.getTiffinSupplierName());
        supplierDTO.setOutletName(supplier.getOutletName());
        supplierDTO.setAddressLine1(supplier.getAddressLine1());
        supplierDTO.setAddressLine2(supplier.getAddressLine2());
        supplierDTO.setLocality(supplier.getLocality());
        supplierDTO.setCity(supplier.getCity());
        if (StringUtils.isNotBlank(supplier.getSTDCode())) {
            supplierDTO.setState(supplier.getState());
        } else {
            supplierDTO.setState(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(supplier.getPincode())) {
            supplierDTO.setPincode(supplier.getPincode());
        } else {
            supplierDTO.setPincode(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(supplier.getSTDCode())) {
            supplierDTO.setsTDCode(supplier.getSTDCode());
        } else {
            supplierDTO.setsTDCode(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(supplier.getLandLine())) {
            supplierDTO.setLandLine(supplier.getLandLine());
        } else {
            supplierDTO.setLandLine(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(supplier.getOwenName())) {
            supplierDTO.setOwnerName(supplier.getOwenName());
        } else {
            supplierDTO.setOwnerName(TiffinSysConstant.EMPTY_STRING);
        }
        supplierDTO.setIsLogoUploaded(supplier.getIsLogoUploaded());
        if (supplier.getRatings() != null) {
            supplierDTO.setRatings(supplier.getRatings().toString());
        } else {
            supplierDTO.setRatings(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(supplier.getDeliveryTime())) {
            supplierDTO.setDeliveryTime(supplier.getDeliveryTime());
        } else {
            supplierDTO.setDeliveryTime(TiffinSysConstant.EMPTY_STRING);
        }
        if (supplier.getPerTiffinPrice() != null) {
            supplierDTO.setPricePerTiffin(supplier.getPerTiffinPrice().toString());
        } else {
            supplierDTO.setPricePerTiffin(TiffinSysConstant.EMPTY_STRING);
        }
        if (supplier.getWeeklyPackagePrice() != null) {
            supplierDTO.setWeeklyPackagePrice(supplier.getWeeklyPackagePrice().toString());
        } else {
            supplierDTO.setWeeklyPackagePrice(TiffinSysConstant.EMPTY_STRING);
        }
        if (supplier.getMonthlyPackagePrice() != null) {
            supplierDTO.setMonthlyPackagePrice(supplier.getMonthlyPackagePrice().toString());
        } else {
            supplierDTO.setMonthlyPackagePrice(TiffinSysConstant.EMPTY_STRING);
        }
        supplierDTO.setIsVeg(supplier.isIsVeg());
        return supplierDTO;
    }

    @Override
    public MessageDTO getSuppllier(String lattitude, String longitude) {
        MessageDTO messageDTO = new MessageDTO();
        Query query = em.createNativeQuery(QueryConstant.GET_SUPPLIER_BY_LAT_LONG, TiffinSupplier.class);
        List<TiffinSupplier> tiffinSuppliers = query.getResultList();
        if (!tiffinSuppliers.isEmpty()) {
            List<SupplierDTO> supplierDTOs = new ArrayList<SupplierDTO>();
            for (TiffinSupplier tiffinSupplier : tiffinSuppliers) {
//                List<TiffinDTO> tiffinDTOs = getTiffin(tiffinSupplier.getTiffinSupplierID());
                SupplierDTO supplierDTO = mapSupplierDTO(tiffinSupplier);
//                supplierDTO.setTiffins(tiffinDTOs);
                supplierDTOs.add(supplierDTO);
            }
            messageDTO.setMessageID(MsgConstant.DATA_AVAILABLE_ID);
            messageDTO.setMessageText(MsgConstant.DATA_AVAILABLE_TEXT);
            messageDTO.setSuppliers(supplierDTOs);
        } else {
            messageDTO.setMessageID(MsgConstant.DATE_NOT_AVAILABLE_ID);
            messageDTO.setMessageText(MsgConstant.DATE_NOT_AVAILABLE_TEXT);
        }
        return messageDTO;
    }

    @Override
    public List<TiffinDTO> getTiffin(String supplierIDs, Boolean isToday, Boolean isLunch) {
        List<TiffinDTO> tiffinDTOs = new ArrayList<TiffinDTO>();
        try {
            Date date = null;
            if (isToday) {
                date = TiffinDateUtils.getCurrentDateOnly();
            } else {
                date = TiffinDateUtils.getDateAfterxDays(TiffinDateUtils.getCurrentDate(), 1);
            }
            List<Integer> iSupplierIDs = TiffinStringUtils.getCommaSeperatedValuesFromString(supplierIDs);
            Query query = em.createNativeQuery(QueryConstant.GET_TIFFIN_BY_SUPPLIER_ID, Tiffin.class)
                    .setParameter("supplierIDs", iSupplierIDs)
                    .setParameter("date", date)
                    .setParameter("IsLunch", isLunch);
            List<Tiffin> tiffins = query.getResultList();
            if (!tiffins.isEmpty()) {
                for (Tiffin tiffin : tiffins) {
                    TiffinDTO tiffinDTO = mapTiffinToDTO(tiffin);
                    tiffinDTOs.add(tiffinDTO);
                }
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return tiffinDTOs;
    }

    private TiffinDTO mapTiffinToDTO(Tiffin tiffin) {
        TiffinDTO tiffinDTO = new TiffinDTO();
        List<TiffinMenuDTO> tiffinMenuDTOs = new ArrayList<TiffinMenuDTO>();
        tiffinDTO.setTiffinID(tiffin.getTiffinID().toString());
        tiffinDTO.setTiffinDate(TiffinDateUtils.getFormattedDateString(tiffin.getTiffinDate()));
        tiffinDTO.setTiffinName(tiffin.getTiffinName());
        if (StringUtils.isNotBlank(tiffin.getImageName())) {
            tiffinDTO.setImageName(tiffin.getImageName());
        } else {
            tiffinDTO.setImageName(TiffinSysConstant.EMPTY_STRING);
        }
        tiffinDTO.setTiffinCharges(tiffin.getTiffinCharges().toString());
        List<TiffinMenu> tiffinMenus = tiffin.getTiffinMenuList();
        if (tiffinMenus != null && !tiffinMenus.isEmpty()) {
            tiffinMenuDTOs = mapTiffinMenuToDTO(tiffinMenus);
        }
        tiffinDTO.setIsVeg(tiffin.isIsVeg());
        tiffinDTO.setMenuItems(tiffinMenuDTOs);
        tiffinDTO.setIsLunch(tiffin.isIsLunch());
        return tiffinDTO;
    }

    private List<TiffinMenuDTO> mapTiffinMenuToDTO(List<TiffinMenu> tiffinMenus) {
        List<TiffinMenuDTO> tiffinMenuDTOs = new ArrayList<TiffinMenuDTO>();
        for (TiffinMenu tiffinMenu : tiffinMenus) {
            TiffinMenuDTO tiffinMenuDTO = new TiffinMenuDTO();
            tiffinMenuDTO.setTiffinMenuID(tiffinMenu.getTiffinMenuID().toString());
            tiffinMenuDTO.setQuantity(tiffinMenu.getQuantity().toString());
            tiffinMenuDTO.setMenuItemname(tiffinMenu.getSubsMenuID().getMenuItemName());
            tiffinMenuDTO.setPricePerUnit(tiffinMenu.getSubsMenuID().getPricePerUnit().toString());
            tiffinMenuDTO.setIsCustomizable(tiffinMenu.getSubsMenuID().getIsCustomizable());
            tiffinMenuDTO.setIsOptional(tiffinMenu.isIsOptional());
            tiffinMenuDTOs.add(tiffinMenuDTO);
        }
        return tiffinMenuDTOs;
    }

    @Override
    public MessageDTO addTiffin(TiffinDTO tiffinDTO) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            Tiffin tiffin = mapTiffin(tiffinDTO);
            if (tiffin != null) {
                if (StringUtils.isNotBlank(tiffinDTO.getTiffinID())) {
                    em.merge(tiffin);
                    messageDTO.setMessageID(MsgConstant.UPDATE_SUCCESS_ID);
                    messageDTO.setMessageText(MsgConstant.UPDATE_SUCCESS_TEXT);
                } else {
                    em.persist(tiffin);
                    messageDTO.setMessageID(MsgConstant.INSERT_SUCCESS_ID);
                    messageDTO.setMessageText(MsgConstant.INSERT_SUCCESS_TEXT);
                    mapTiffinMenuItems(tiffin.getTiffinID(), tiffinDTO.getMenuItems());
                }
                // code to add and edit subsmenu
                TiffinDTO tdto = mapTiffinToDTO(tiffin);
                messageDTO.setTiffin(tdto);
            }
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private Tiffin mapTiffin(TiffinDTO tiffinDTO) {
        Tiffin tiffin;
        if (StringUtils.isNotBlank(tiffinDTO.getTiffinID())) {
            tiffin = em.find(Tiffin.class, Integer.parseInt(tiffinDTO.getTiffinID()));
            if (tiffin == null) {
                return null;
            }
        } else {
            tiffin = new Tiffin();
            tiffin.setCreatedDateTime(TiffinDateUtils.getCurrentDateAndTime());
        }
        tiffin.setTiffinName(tiffinDTO.getTiffinName());
        tiffin.setTiffinDate(TiffinDateUtils.getFormattedDate(tiffinDTO.getTiffinDate()));
        tiffin.setSupplierID(Integer.parseInt(tiffinDTO.getSupplierID()));
        tiffin.setTiffinCharges(new BigDecimal(tiffinDTO.getTiffinCharges()));
        tiffin.setIsLunch(tiffinDTO.isIsLunch());
        tiffin.setIsVeg(tiffinDTO.isIsVeg());
        tiffin.setIsActive(Boolean.TRUE);
        return tiffin;
    }

    @Override
    public MessageDTO addSubsMenu(SubsMenuDTO subsMenuDTO) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            SubsMenu subsMenu = mapSubsMenu(subsMenuDTO);
            if (subsMenu != null) {
                if (StringUtils.isNotBlank(subsMenuDTO.getSubsMenuID())) {
                    em.merge(subsMenu);
                    messageDTO.setMessageID(MsgConstant.UPDATE_SUCCESS_ID);
                    messageDTO.setMessageText(MsgConstant.UPDATE_SUCCESS_TEXT);
                } else {
                    em.persist(subsMenu);
                    messageDTO.setMessageID(MsgConstant.INSERT_SUCCESS_ID);
                    messageDTO.setMessageText(MsgConstant.INSERT_SUCCESS_TEXT);
                }
                messageDTO.setSubsMenuID(subsMenu.getSubsMenuID().toString());
            }

        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private SubsMenu mapSubsMenu(SubsMenuDTO subsMenuDTO) {
        SubsMenu subsMenu;
        if (StringUtils.isNotBlank(subsMenuDTO.getSubsMenuID())) {
            subsMenu = em.find(SubsMenu.class, Integer.parseInt(subsMenuDTO.getSubsMenuID()));
            if (subsMenu == null) {
                return null;
            }
        } else {
            subsMenu = new SubsMenu();
            subsMenu.setCreatedDateTime(TiffinDateUtils.getCurrentDateAndTime());
        }
        subsMenu.setIsCustomizable(subsMenuDTO.isIsCustomizable());
        subsMenu.setMenuItemName(subsMenuDTO.getMenuItemName());
        subsMenu.setSupplierID(Integer.parseInt(subsMenuDTO.getSupplierID()));
        subsMenu.setPricePerUnit(new BigDecimal(subsMenuDTO.getPricePerUnit()));
        return subsMenu;
    }

    @Override
    public MessageDTO addTiffinMenu(TiffinMenusDTO tiffinMenusDTO) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            for (TiffinMenuDTO tiffinMenuDTO : tiffinMenusDTO.getTiffinMenus()) {
                TiffinMenu tiffinMenu = mapTiffinMenu(tiffinMenuDTO);
                if (tiffinMenu != null) {
                    if (StringUtils.isNotBlank(tiffinMenuDTO.getTiffinMenuID())) {
                        em.merge(tiffinMenu);
                        messageDTO.setMessageID(MsgConstant.UPDATE_SUCCESS_ID);
                        messageDTO.setMessageText(MsgConstant.UPDATE_SUCCESS_TEXT);
                    } else {
                        em.persist(tiffinMenu);
                        messageDTO.setMessageID(MsgConstant.INSERT_SUCCESS_ID);
                        messageDTO.setMessageText(MsgConstant.INSERT_SUCCESS_TEXT);
                    }
                }
            }
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private TiffinMenu mapTiffinMenu(TiffinMenuDTO tiffinMenuDTO) {
        TiffinMenu tiffinMenu;
        if (StringUtils.isNotBlank(tiffinMenuDTO.getTiffinMenuID())) {
            tiffinMenu = em.find(TiffinMenu.class, Integer.parseInt(tiffinMenuDTO.getTiffinMenuID()));
            if (tiffinMenu == null) {
                return null;
            }
        } else {
            tiffinMenu = new TiffinMenu();
        }
        Tiffin tiffin = em.find(Tiffin.class, Integer.parseInt(tiffinMenuDTO.getTiffinID()));
        tiffinMenu.setTiffinID(tiffin);
        tiffinMenu.setIsOptional(tiffinMenuDTO.isIsOptional());
        tiffinMenu.setQuantity(Integer.parseInt(tiffinMenuDTO.getQuantity()));
        SubsMenu subsMenu = em.find(SubsMenu.class, Integer.parseInt(tiffinMenuDTO.getSubsMenuID()));
        tiffinMenu.setSubsMenuID(subsMenu);
        return tiffinMenu;
    }

    @Override
    public MessageDTO getSubsMenu(Integer supplierID) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            List<SubsMenuDTO> subsMenuDTOs = new ArrayList<SubsMenuDTO>();
            Query query = em.createNativeQuery(QueryConstant.GET_SUBS_MENU_BY_SUPPLIER_ID, SubsMenu.class)
                    .setParameter("supplierID", supplierID);
            List<SubsMenu> subsMenus = query.getResultList();
            for (SubsMenu subsMenu : subsMenus) {
                SubsMenuDTO subsMenuDTO = mapSubsMenuToDTO(subsMenu);
                subsMenuDTOs.add(subsMenuDTO);
            }
            messageDTO.setSubsMenus(subsMenuDTOs);
            messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private SubsMenuDTO mapSubsMenuToDTO(SubsMenu subsMenu) {
        SubsMenuDTO subsMenuDTO = new SubsMenuDTO();
        subsMenuDTO.setSubsMenuID(subsMenu.getSubsMenuID().toString());
        subsMenuDTO.setMenuItemName(subsMenu.getMenuItemName());
        return subsMenuDTO;
    }

    private void mapTiffinMenuItems(Integer tiffinID, List<TiffinMenuDTO> menuItems) {
        List<TiffinMenuDTO> tiffinMenuDTOs = new ArrayList<TiffinMenuDTO>();
        TiffinMenusDTO tiffinMenusDTO = new TiffinMenusDTO();
        for (TiffinMenuDTO tiffinMenuDTO : menuItems) {
            tiffinMenuDTO.setTiffinID(tiffinID.toString());
            tiffinMenuDTOs.add(tiffinMenuDTO);
        }
        tiffinMenusDTO.setTiffinMenus(tiffinMenuDTOs);
        addTiffinMenu(tiffinMenusDTO);
    }

    @Override
    public MessageDTO getAddOns() {
        MessageDTO messageDTO = new MessageDTO();
        List<AddOnsDTO> addOnsDTOs = new ArrayList<AddOnsDTO>();
        try {
            Query query = em.createNamedQuery("AddOns.findAll");
            List<AddOns> addOnList = query.getResultList();
            if (!addOnList.isEmpty()) {
                for (AddOns addOns : addOnList) {
                    AddOnsDTO addOnsDTO = createAddOnsDTO(addOns);
                    addOnsDTOs.add(addOnsDTO);
                }
            }
            messageDTO.setAddOns(addOnsDTOs);
            messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    private AddOnsDTO createAddOnsDTO(AddOns addOns) {
        AddOnsDTO addOnsDTO = new AddOnsDTO();
        addOnsDTO.setAddOnsID(addOns.getAddOnsID().toString());
        addOnsDTO.setAddOnsName(addOns.getAddOnsName());
        addOnsDTO.setPricePerUnit(addOns.getPricePerUnit().toString());
        if (StringUtils.isNotBlank(addOns.getImageName())) {
            addOnsDTO.setImageName(addOns.getImageName());
        } else if (addOns.getAddOnsID() % 2 == 0) {
            addOnsDTO.setImageName("https://thecrazyperfectionist.files.wordpress.com/2015/05/srb13cw135-w-ice-cream.jpg");
        } else {
            addOnsDTO.setImageName("http://www.sailingeurope.com/blog/file/2015/07/Salad.jpg");
        }
        if (addOns.getPriority() != null) {
            addOnsDTO.setPriority(addOns.getPriority().toString());
        } else {
            addOnsDTO.setPriority(TiffinSysConstant.EMPTY_STRING);
        }
        return addOnsDTO;
    }

    @Override
    public MessageDTO getMyOrders(Integer supplierID, Date orderDate) {
        MessageDTO messageDTO = new MessageDTO();
        List<CustomerOrderDTO> customerOrderDTOs = new ArrayList<CustomerOrderDTO>();
        try {
            Query query = em.createNativeQuery(QueryConstant.GET_CUSTOMER_DETIALS_FOR_ORDER, CustomerOrder.class)
                    .setParameter("supplierID", supplierID)
                    .setParameter("orderDate", orderDate);
            List<CustomerOrder> customerOrders = query.getResultList();
            for (CustomerOrder customerOrder : customerOrders) {
                CustomerOrderDTO customerOrderDTO = mapCustomerOrderDTO(customerOrder);
                customerOrderDTOs.add(customerOrderDTO);
            }
            messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
            messageDTO.setMyOrders(customerOrderDTOs);
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
            messageDTO.setMyOrders(customerOrderDTOs);
        }
        return messageDTO;
    }

    private CustomerOrderDTO mapCustomerOrderDTO(CustomerOrder customerOrder) {
        CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();
        customerOrderDTO.setOrder_id(customerOrder.getOrder_id().toString());
        customerOrderDTO.setCustomerID(customerOrder.getCustomerID().toString());
        if (customerOrder.getIsFirstOrder() != null) {
            customerOrderDTO.setIsFirstOrder(customerOrder.getIsFirstOrder());
        } else {
            customerOrderDTO.setIsFirstOrder(Boolean.FALSE);
        }
//        customerOrderDTO.setTiffinName(customerOrder.getTiffinName());
        customerOrderDTO.setFullName(customerOrder.getFullName());
        customerOrderDTO.setSMSPhone(customerOrder.getSMSPhone().toString());
        if (StringUtils.isNotBlank(customerOrder.getAddressLine1())) {
            customerOrderDTO.setAddressLine1(customerOrder.getAddressLine1());
        } else {
            customerOrderDTO.setAddressLine1(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(customerOrder.getAddressLine2())) {
            customerOrderDTO.setAddressLine2(customerOrder.getAddressLine2());
        } else {
            customerOrderDTO.setAddressLine2(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(customerOrder.getAddressTag())) {
            customerOrderDTO.setAddressTag(customerOrder.getAddressTag());
        } else {
            customerOrderDTO.setAddressTag(TiffinSysConstant.EMPTY_STRING);
        }
//        customerOrderDTO.setTiffinCount(customerOrder.getTiffins().toString());
        customerOrderDTO.setPaymentMode(customerOrder.getPaymentMode());
        if (customerOrder.getReceivable() != null) {
            customerOrderDTO.setReceivable(customerOrder.getReceivable().toString());
        } else {
            customerOrderDTO.setReceivable(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(customerOrder.getLocality())) {
            customerOrderDTO.setLocality(customerOrder.getLocality());
        } else {
            customerOrderDTO.setLocality(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(customerOrder.getCity())) {
            customerOrderDTO.setCity(customerOrder.getCity());
        } else {
            customerOrderDTO.setCity(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(customerOrder.getLattitude())) {
            customerOrderDTO.setLattitude(customerOrder.getLattitude());
        } else {
            customerOrderDTO.setLattitude(TiffinSysConstant.EMPTY_STRING);
        }
        if (StringUtils.isNotBlank(customerOrder.getLongitude())) {
            customerOrderDTO.setLongitude(customerOrder.getLongitude());
        } else {
            customerOrderDTO.setLongitude(TiffinSysConstant.EMPTY_STRING);
        }

        customerOrderDTO.setOrderDetails(mapOrderDetailsDTO(customerOrder.getOrder_id()));

        return customerOrderDTO;
    }

    private List<OrderDetailsDTO> mapOrderDetailsDTO(Integer orderID) {
        List<OrderDetailsDTO> detailsDTO = new ArrayList<OrderDetailsDTO>();
        try {
            Query query = em.createNativeQuery(QueryConstant.GET_ORDER_DETAILS_BY_TIFFIN_ID, OrderDetails.class)
                    .setParameter("orderID", orderID);
            List<OrderDetails> detailsList = query.getResultList();
            detailsDTO = mapOrderDetailsToDTO(detailsList);
        } catch (Exception e) {

        }
        return detailsDTO;
    }

    private List<OrderDetailsDTO> mapOrderDetailsToDTO(List<OrderDetails> detailsList) {
        List<OrderDetailsDTO> detailsDTOs = new ArrayList<OrderDetailsDTO>();
        for (OrderDetails orderDetails : detailsList) {
            OrderDetailsDTO detailsDTO = new OrderDetailsDTO();
            if (orderDetails.getTiffinID() != null) {
                Tiffin tiffin = em.find(Tiffin.class, orderDetails.getTiffinID());
                detailsDTO.setTiffinName(tiffin.getTiffinName());
            } else {
                detailsDTO.setTiffinName(TiffinSysConstant.EMPTY_STRING);
            }
            if (orderDetails.getTiffinCost() != null) {
                detailsDTO.setTiffinCost(orderDetails.getTiffinCost().toString());
            } else {
                detailsDTO.setTiffinCost(TiffinSysConstant.EMPTY_STRING);
            }
            if (orderDetails.getTiffinCount() != null) {
                detailsDTO.setTiffinCount(orderDetails.getTiffinCount().toString());
            } else {
                detailsDTO.setTiffinCount(TiffinSysConstant.EMPTY_STRING);
            }
            if (orderDetails.getAddOnID() != null) {
                AddOns addOns = em.find(AddOns.class, orderDetails.getAddOnID());
                detailsDTO.setAddOnName(addOns.getAddOnsName());
            } else {
                detailsDTO.setAddOnName(TiffinSysConstant.EMPTY_STRING);
            }
            if (orderDetails.getAddOnCost() != null) {
                detailsDTO.setAddOnCost(orderDetails.getAddOnCost().toString());
            } else {
                detailsDTO.setAddOnCost(TiffinSysConstant.EMPTY_STRING);
            }
            if (orderDetails.getAddOnCount() != null) {
                detailsDTO.setAddOnCount(orderDetails.getAddOnCount().toString());
            } else {
                detailsDTO.setAddOnCount(TiffinSysConstant.EMPTY_STRING);
            }
            if (orderDetails.getIsLunch() != null) {
                orderDetails.setIsLunch(orderDetails.getIsLunch());
            } else {
                orderDetails.setIsLunch(Boolean.TRUE);
            }
            detailsDTOs.add(detailsDTO);
        }
        return detailsDTOs;
    }

}
