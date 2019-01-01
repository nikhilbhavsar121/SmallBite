/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.servicebean;

import com.rebindtech.tiffin.constants.AppMsgConstant;
import com.rebindtech.tiffin.constants.QueryConstant;
import com.rebindtech.tiffin.constants.TiffinSysConstant;
import com.rebindtech.tiffin.dto.CityDTO;
import com.rebindtech.tiffin.dto.LocalityDTO;
import com.rebindtech.tiffin.dto.NoticeDTO;
import com.rebindtech.tiffin.dto.OfferDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.entity.City;
import com.rebindtech.tiffin.entity.Locality;
import com.rebindtech.tiffin.entity.NoticeBoard;
import com.rebindtech.tiffin.entity.Offer;
import com.rebindtech.tiffin.service.MiscService;
import com.rebindtech.tiffin.utils.TiffinDateUtils;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mrsagar
 */
@Stateless
public class MiscServiceBean implements MiscService {

    @PersistenceContext
    EntityManager em;

    @EJB
    DeviceNotificationHelper notificationHelper;

    @Override
    public MessageDTO sendNotificationToUsers(String data, String appType) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            notificationHelper.sendToAllUsers(data, appType);
            messageDTO.setMessageID(AppMsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(AppMsgConstant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            messageDTO.setMessageID(AppMsgConstant.FAILURE_ID);
            messageDTO.setMessageText(AppMsgConstant.FAILURE_MESSAGE);
        }
        return messageDTO;
    }

    @Override
    public List<CityDTO> getCity() {
        List<CityDTO> cityDTOs = new ArrayList<CityDTO>();
        Query query = em.createNamedQuery("City.findAll");
        List<City> citys = query.getResultList();
        for (City city : citys) {
            CityDTO cityDTO = mapCityToDTO(city);
            cityDTOs.add(cityDTO);
        }
        return cityDTOs;
    }

    private CityDTO mapCityToDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityID(city.getCityID().toString());
        cityDTO.setCityName(city.getCityName());
        List<LocalityDTO> localityDTOs = mapLocalitiesToDTO(city.getLocalityList());
        cityDTO.setLocalities(localityDTOs);
        return cityDTO;
    }

    private List<LocalityDTO> mapLocalitiesToDTO(List<Locality> localityList) {
        List<LocalityDTO> localityDTOs = new ArrayList<LocalityDTO>();
        for (Locality locality : localityList) {
            LocalityDTO localityDTO = new LocalityDTO();
            localityDTO.setLocalityID(locality.getLocalityID().toString());
            localityDTO.setLocalityName(locality.getLocalityName());
            if (locality.getDeliveryCharges() != null) {
                localityDTO.setDeliveryCharges(locality.getDeliveryCharges().toString());
            } else {
                localityDTO.setDeliveryCharges(TiffinSysConstant.EMPTY_STRING);
            }
            localityDTO.setSupplierIDs(locality.getSupplierIDs());
            localityDTOs.add(localityDTO);
        }
        return localityDTOs;
    }

    @Override
    public List<OfferDTO> getOffers() {
        List<OfferDTO> offerDTOs = new ArrayList<OfferDTO>();
        try {
            Query query = em.createNativeQuery(QueryConstant.GET_ACTIVE_OFFERS, Offer.class);
            List<Offer> offers = query.getResultList();
            for (Offer offer : offers) {
                OfferDTO offerDTO = mapOfferDTO(offer);
                offerDTOs.add(offerDTO);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return offerDTOs;
    }

    private OfferDTO mapOfferDTO(Offer offer) {
        OfferDTO offerDTO = new OfferDTO();
        offerDTO.setOfferID(offer.getOfferID().toString());
        offerDTO.setOfferDate(TiffinDateUtils.getFormattedDateString(offer.getOfferDate()));
        offerDTO.setValidUpto(TiffinDateUtils.getFormattedDateString(offer.getValidUpto()));
        offerDTO.setOfferName(offer.getOfferName());
        offerDTO.setOfferCode(offer.getOfferCode());
        offerDTO.setImageName(offer.getImageName());
        if (offer.getDiscountAmount() != null) {
            offerDTO.setDiscountAmount(offer.getDiscountAmount().toString());
        } else {
            offerDTO.setDiscountAmount(TiffinSysConstant.EMPTY_STRING);
        }
        if (offer.getDiscountPerc() != null) {
            offerDTO.setDiscountPerc(offer.getDiscountPerc().toString());
        } else {
            offerDTO.setDiscountPerc(TiffinSysConstant.EMPTY_STRING);
        }
        if (offer.getMinPurchaseAmt() != null) {
            offerDTO.setMinPurchaseAmt(offer.getMinPurchaseAmt().toString());
        } else {
            offerDTO.setMinPurchaseAmt(TiffinSysConstant.EMPTY_STRING);
        }
        if (offer.getMaxCashbackAmt() != null) {
            offerDTO.setMaxCashbackAmt(offer.getMaxCashbackAmt().toString());
        } else {
            offerDTO.setMaxCashbackAmt(TiffinSysConstant.EMPTY_STRING);
        }
        offerDTO.setIsActive(offer.getIsActive());
        return offerDTO;
    }

    @Override
    public NoticeDTO getNotice() {
        NoticeDTO noticeDTO = new NoticeDTO();
        try {
            Query query = em.createNativeQuery(QueryConstant.GET_NOTICE);
            NoticeBoard noticeBoard = (NoticeBoard) query.getSingleResult();
            noticeDTO.setNoticeId(noticeBoard.getNoticeBoardId().toString());
            noticeDTO.setNoticeStartDate(TiffinDateUtils.getFormattedDateString(noticeBoard.getNoticeStartDate()));
            noticeDTO.setNoticeEndDate(TiffinDateUtils.getFormattedDateString(noticeBoard.getNoticeEndDate()));
            noticeDTO.setNotice(noticeBoard.getNotice());
        } catch (Exception e) {
            return noticeDTO;
        }
        return noticeDTO;
    }
}
