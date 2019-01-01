package com.rebindtech.tiffin.ctrlimpl;

import com.rebindtech.tiffin.ctrl.MobileDeviceCtrl;
import com.rebindtech.tiffin.dto.MobileDeviceDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.service.JNDIService;
import com.rebindtech.tiffin.service.MobileDeviceService;
import com.rebindtech.tiffin.utils.JsonConverter;

/**
 *
 * @author Govind
 */
public class MobileDeviceCtrlImpl implements MobileDeviceCtrl {

    @Override
    public String addMobileDevice(MobileDeviceDTO mobileDeviceDTO) {
        MobileDeviceService mobileDeviceService = JNDIService.getMobileDeviceService();
        MessageDTO messageDTO = mobileDeviceService.addMobileDevice(mobileDeviceDTO);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

}
