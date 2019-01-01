/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rebindtech.tiffin.service;

import com.rebindtech.tiffin.dto.CityDTO;
import com.rebindtech.tiffin.dto.NoticeDTO;
import com.rebindtech.tiffin.dto.OfferDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mrsagar
 */
@Local
public interface MiscService {

    public MessageDTO sendNotificationToUsers(String data, String appType);

    public List<CityDTO> getCity();

    public List<OfferDTO> getOffers();

    public NoticeDTO getNotice();
    
}
