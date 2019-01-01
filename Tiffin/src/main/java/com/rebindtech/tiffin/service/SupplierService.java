
package com.rebindtech.tiffin.service;

import com.rebindtech.tiffin.dto.AddOnsDTO;
import com.rebindtech.tiffin.dto.CustomerOrderDTO;
import com.rebindtech.tiffin.dto.SubsMenuDTO;
import com.rebindtech.tiffin.dto.SupplierDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.dto.TiffinDTO;
import com.rebindtech.tiffin.dto.TiffinMenusDTO;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sagar
 */
@Local
public interface SupplierService {

    public MessageDTO addSupplier(SupplierDTO supplierDTO);

    public MessageDTO getSuppllier(String lattitude, String longitude);

    public List<TiffinDTO> getTiffin(String supplierIDs,Boolean isToday,Boolean isLunch);

    public MessageDTO addTiffin(TiffinDTO tiffinDTO);

    public MessageDTO addSubsMenu(SubsMenuDTO subsMenuDTO);

    public MessageDTO addTiffinMenu(TiffinMenusDTO tiffinMenusDTO);

    public MessageDTO getSubsMenu(Integer supplierID);

    public MessageDTO getAddOns();

    public MessageDTO getMyOrders(Integer supplierID,Date orderDate);
    
}
