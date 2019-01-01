package com.rebindtech.tiffin.service;

import com.rebindtech.tiffin.dto.MobileDeviceDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import javax.ejb.Local;

/**
 *
 * @author Govind
 */
@Local
public interface MobileDeviceService {
    public MessageDTO addMobileDevice(MobileDeviceDTO mobileDeviceDTO);
}
