/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.ctrlimpl;

import com.rebindtech.tiffin.auth.Authentication;
import com.rebindtech.tiffin.constants.AppMsgConstant;
import com.rebindtech.tiffin.ctrl.MiscCtrl;
import com.rebindtech.tiffin.dto.AppVersionDTO;
import com.rebindtech.tiffin.dto.CityDTO;
import com.rebindtech.tiffin.dto.NoticeDTO;
import com.rebindtech.tiffin.dto.OfferDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.service.JNDIService;
import com.rebindtech.tiffin.service.MiscService;
import com.rebindtech.tiffin.utils.JsonConverter;
import java.util.List;

/**
 *
 * @author mrsagar
 */
public class MiscCtrlImpl extends Authentication implements MiscCtrl {

    MiscService miscService = JNDIService.getMiscService();

    @Override
    public String sendNotificationToUsers(String data, String appType) {
        MessageDTO messageDTO = authenticationCheck(getAppRequest());
        if (messageDTO.getMessageID().equals(AppMsgConstant.VALID_URL_SUCCESS_ID)) {
            messageDTO = miscService.sendNotificationToUsers(data, appType);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String getCity() {
        List<CityDTO> cityDTOs = miscService.getCity();
        return JsonConverter.createJsonFromDTO(cityDTOs);
    }

    @Override
    public String getOffers() {
        List<OfferDTO> offerDTOs = miscService.getOffers();
        return JsonConverter.createJsonFromDTO(offerDTOs);
    }

    @Override
    public String getNotice() {
        NoticeDTO noticeDTO = miscService.getNotice();
        return JsonConverter.createJsonFromDTO(noticeDTO);
    }

    @Override
    public String getAppVerion() {
        AppVersionDTO appVersionDTO = new AppVersionDTO();
        appVersionDTO.setAppVersion("2.1");
        appVersionDTO.setIsForceUpdate(Boolean.TRUE);
        return JsonConverter.createJsonFromDTO(appVersionDTO);
    }

}
