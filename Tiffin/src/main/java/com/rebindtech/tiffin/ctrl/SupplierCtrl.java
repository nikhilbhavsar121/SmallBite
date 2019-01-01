package com.rebindtech.tiffin.ctrl;

import com.rebindtech.tiffin.dto.SubsMenuDTO;
import com.rebindtech.tiffin.dto.SupplierDTO;
import com.rebindtech.tiffin.dto.TiffinDTO;
import com.rebindtech.tiffin.dto.TiffinMenusDTO;

/**
 *
 * @author Sagar
 */
public interface SupplierCtrl extends AuthenticationCtrl {

    public String addSupplier(SupplierDTO supplierDTO);

    public String getSuppllier(String lattitude, String longitude);

    public String getTiffin(String supplierIDs,Boolean isToday,Boolean isLunch);

    public String addTiffin(TiffinDTO tiffinDTO);

    public String addSubsMenu(SubsMenuDTO subsMenuDTO);

    public String addTiffinMenu(TiffinMenusDTO tiffinMenusDTO);

    public String getSubsMenu(Integer supplierID);

    public String getAddOns();

    public String getMyOrders(Integer supplierID,String orderDate);

}
