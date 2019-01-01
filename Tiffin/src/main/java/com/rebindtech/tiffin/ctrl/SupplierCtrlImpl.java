package com.rebindtech.tiffin.ctrl;

import com.rebindtech.tiffin.auth.Authentication;
import com.rebindtech.tiffin.constants.AppMsgConstant;
import com.rebindtech.tiffin.dto.SubsMenuDTO;
import com.rebindtech.tiffin.dto.SupplierDTO;
import com.rebindtech.tiffin.dto.TiffinDTO;
import com.rebindtech.tiffin.dto.TiffinMenusDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.service.JNDIService;
import com.rebindtech.tiffin.service.SupplierService;
import com.rebindtech.tiffin.utils.JsonConverter;
import com.rebindtech.tiffin.utils.TiffinDateUtils;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sagar
 */
public class SupplierCtrlImpl extends Authentication implements SupplierCtrl {

    SupplierService supplierService = JNDIService.getSupplierService();

    @Override
    public String addSupplier(SupplierDTO supplierDTO) {
        MessageDTO messageDTO = supplierService.addSupplier(supplierDTO);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String getSuppllier(String lattitude, String longitude) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = supplierService.getSuppllier(lattitude, longitude);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String getTiffin(String supplierIDs, Boolean isToday,Boolean isLunch) {
        List<TiffinDTO> tiffinDTOs = supplierService.getTiffin(supplierIDs, isToday,isLunch);
        return JsonConverter.createJsonFromDTO(tiffinDTOs);
    }

    @Override
    public String addTiffin(TiffinDTO tiffinDTO) {
        // code for authentication check
        MessageDTO messageDTO = supplierService.addTiffin(tiffinDTO);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String addSubsMenu(SubsMenuDTO subsMenuDTO) {
        MessageDTO messageDTO = supplierService.addSubsMenu(subsMenuDTO);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String addTiffinMenu(TiffinMenusDTO tiffinMenusDTO) {
        MessageDTO messageDTO = supplierService.addTiffinMenu(tiffinMenusDTO);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String getSubsMenu(Integer supplierID) {
        MessageDTO messageDTO = supplierService.getSubsMenu(supplierID);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String getAddOns() {
        MessageDTO messageDTO = supplierService.getAddOns();
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String getMyOrders(Integer supplierID,String strOrderDate) {
        Date orderDate=TiffinDateUtils.getFormattedDate(strOrderDate);
        MessageDTO messageDTO = supplierService.getMyOrders(supplierID,orderDate);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }
}
