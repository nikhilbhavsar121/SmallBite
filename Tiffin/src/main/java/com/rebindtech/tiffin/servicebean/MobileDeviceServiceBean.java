package com.rebindtech.tiffin.servicebean;

import com.rebindtech.tiffin.constants.MsgConstant;
import com.rebindtech.tiffin.constants.QueryConstant;
import com.rebindtech.tiffin.dto.MobileDeviceDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.entity.MobileDevice;
import com.rebindtech.tiffin.service.MobileDeviceService;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Govind
 */
@Stateless
public class MobileDeviceServiceBean implements MobileDeviceService {

    @PersistenceContext
    EntityManager em;

    @Override
    public MessageDTO addMobileDevice(MobileDeviceDTO mobileDeviceDTO) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            MobileDevice mobileDevice = mapMobileDeviceEntity(mobileDeviceDTO);
            if (mobileDevice.getMobileDeviceID() != null) {
                em.merge(mobileDevice);
            } else {
                em.persist(mobileDevice);
            }
            messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }

        return messageDTO;
    }

    private MobileDevice mapMobileDeviceEntity(MobileDeviceDTO mobileDeviceDTO) {
        MobileDevice mobileDevice = getmobileDeviceByCustomerID(mobileDeviceDTO.getCustomerID());
        mobileDevice.setAppType(mobileDeviceDTO.getAppType());
        mobileDevice.setDeviceToken(mobileDeviceDTO.getDeviceToken());
        mobileDevice.setCustomerID(mobileDeviceDTO.getCustomerID());
        mobileDevice.setAppVersion(mobileDeviceDTO.getAppVersion());
        return mobileDevice;
    }

    private MobileDevice getmobileDeviceByCustomerID(Integer customerID) {
        MobileDevice mobileDevice;
        try {
            Query query = em.createNativeQuery(QueryConstant.GET_MOBILE_DEVICE_BY_PERSONID,MobileDevice.class)
                    .setParameter("customerID", customerID)
                    .setParameter("appType", "C");
            mobileDevice = (MobileDevice) query.getSingleResult();

        } catch (NoResultException e) {
            mobileDevice = new MobileDevice();
        }
        return mobileDevice;
    }
}
