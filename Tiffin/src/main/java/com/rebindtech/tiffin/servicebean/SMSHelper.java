package com.rebindtech.tiffin.servicebean;

import com.rebindtech.tiffin.constants.EmailSMSConstant;
import com.rebindtech.tiffin.constants.TiffinSysConstant;
import com.rebindtech.tiffin.customer.TiffinCustomer;
import com.rebindtech.tiffin.dto.core.SmsDTO;
import com.rebindtech.tiffin.entity.SMSLog;
import com.rebindtech.tiffin.entity.SMSReason;
import com.rebindtech.tiffin.utils.TiffinDateUtils;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Sagar
 */
@Stateless
public class SMSHelper {

    @PersistenceContext
    EntityManager em;

    public void sendSMS(SmsDTO smsDTO) {
        SMSLog sMSLog = new SMSLog();
        String smsText = createSMSText(smsDTO);
        if (smsDTO.getSmsNumber() != null && StringUtils.isNotBlank(smsText)) {
            sMSLog.setCustomerID(smsDTO.getReceiverID());
            sMSLog.setReceiverName(smsDTO.getReceiverName());
            sMSLog.setSMSSender(TiffinSysConstant.SMS_SENDER_ID);
            sMSLog.setSMSText(smsText);
            sMSLog.setSMSNumber(smsDTO.getSmsNumber());
            sMSLog.setSMSScheduledDateTime(TiffinDateUtils.getCurrentDateAndTime());
            em.persist(sMSLog);
            SMSClient.sendSMS(sMSLog);
        }

    }

    private String createSMSText(SmsDTO smsDTO) {
        String smsText;
        SMSReason sMSReason = em.find(SMSReason.class, smsDTO.getSmsReasonID());
        smsText = sMSReason.getSMSText()
                .replace("<CustName>", smsDTO.getReceiverName())
                .replace("<VerificationCode>", smsDTO.getAuthToken());
        if (smsDTO.getSmsReasonID() == EmailSMSConstant.ORDER_STATUS_EMAIL_SMS_REASON_ID
                || smsDTO.getSmsReasonID() == EmailSMSConstant.PAYMENT_STATUS_EMAIL_SMS_REASON_ID) {
            smsText = smsText.replace("<OrderNumber>", smsDTO.getOrderNo())
                    .replace("<OrderAmount>", smsDTO.getOrderAmount())
                    .replace("<OrderStatus>", smsDTO.getOrderStatus());
        }
        return smsText;
    }

    public void sendAdminNotification(TiffinCustomer customer) {
        String signupString = "New signup from " + customer.getFullName() + " Mobile: " + customer.getSMSPhone().toString();
        SMSClient.sendAdminSMS(signupString);
    }
}
