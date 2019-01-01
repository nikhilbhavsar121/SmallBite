package com.rebindtech.tiffin.servicebean;

import com.rebindtech.tiffin.constants.QueryConstant;
import com.rebindtech.tiffin.entity.MobileDevice;
import com.rebindtech.tiffin.utils.DeviceNotificationUtils;
import java.io.IOException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Govind
 */
@Stateless
public class DeviceNotificationHelper {

    @PersistenceContext
    EntityManager em;

    public void sendByUserID(Integer personID, String data, String appType) {
        try {
            //Integer iPersonID = Integer.parseInt(personID);
//            String data = JsonConverter.createJsonFromDTO(dataObject);
            Query query = em.createNativeQuery(QueryConstant.GET_MOBILE_DEVICE_BY_PERSONID, MobileDevice.class)
                    .setParameter("customerID", personID)
                    .setParameter("appType", appType);

            List<MobileDevice> mobileDevices = query.getResultList();
            for (MobileDevice mobileDevice : mobileDevices) {
                sendNotification(mobileDevice.getDeviceToken(), data);
            }
        } catch (Exception e) {
        }
    }

    public void sendToAllUsers(String data, String appType) {
        try {
            //Integer iPersonID = Integer.parseInt(personID);
//            String data = JsonConverter.createJsonFromDTO(dataObject);
            Query query = em.createNativeQuery(QueryConstant.GET_MOBILE_DEVICE_BY_APP_TYPE, MobileDevice.class)
                    .setParameter("appType", appType);

            List<MobileDevice> mobileDevices = query.getResultList();
            for (MobileDevice mobileDevice : mobileDevices) {
                sendNotification(mobileDevice.getDeviceToken(), data);
            }
        } catch (Exception e) {
        }
    }

    private void sendNotification(String regID, String data) {
        try {
            String serverKey = DeviceNotificationUtils.getAndroidServerKey();
            Sender sender = new Sender(serverKey);
            Message message = new Message.Builder()
                    .addData("data", data).build();
            Result result = sender.send(message, regID, 5);
            if (result != null && result.getMessageId() != null && !result.getMessageId().isEmpty()) {
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        }

    }
//    public MessageDTO unregisterMobileDevice(Integer personID, String deviceID) {
//        MessageDTO messageDTO = new MessageDTO();
//        try {
//            if (personID != null && StringUtils.isNotBlank(deviceID)) {
//                Query query = em.createQuery(QueryConstants.UNREGISTER_MOBILE_DEVICE_BY_PERSON_DEVICEID)
//                        .setParameter("personID", personID)
//                        .setParameter("deviceID", deviceID);
//
//                query.executeUpdate();
//            }
//            messageDTO.setMessageId(PMBSMsgConstants.SUCCESS_ID);
//            messageDTO.setMessageText(PMBSMsgConstants.SUCCESS_MESSAGE);
//        } catch (Exception e) {
//            logger.error(DeviceNotificationHelper.class + " ERROR IN unregisterMobileDevice() : " + e.toString());
//            messageDTO.setMessageId(PMBSMsgConstants.SUCCESS_ID);
//            messageDTO.setMessageText(PMBSMsgConstants.SUCCESS_MESSAGE);
//        }
//
//        return messageDTO;
//    }
}
