package com.rebindtech.tiffin.auth;

import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.constants.AppConstant;
import com.rebindtech.tiffin.constants.AppMsgConstant;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author mrsagar
 */
public class Authentication {

    private HttpServletRequest apprequest = null;

    public final MessageDTO authenticationCheck(HttpServletRequest request) {
        MessageDTO messageDTO = new MessageDTO();
//        String key = getAuthenticatedKey(request);
        boolean isValidUser = true;//validateUser(key);
        if (isValidUser) {
            messageDTO.setMessageID(AppMsgConstant.VALID_URL_SUCCESS_ID);
            messageDTO.setMessageText(AppMsgConstant.VALID_URL_SUCCESS_TEXT);
        } else {
            messageDTO.setMessageID(AppMsgConstant.VALID_URL_FAILURE_ID);
            messageDTO.setMessageText(AppMsgConstant.VALID_URL_FAILURE_TEXT);
        }
        return messageDTO;
    }

    private String getAuthenticatedKey(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = null;
        if (session.getAttribute(AppConstant.LOGGED_IN_USER) != null) {
            LoggedInUser user = (LoggedInUser) session.getAttribute(AppConstant.LOGGED_IN_USER);
            if (user != null && user.getUserName() != null) {
                userName = user.getUserName();
            }
        }
        return userName;
    }

    public boolean validateUser(String key) {//, String allowedUserRole) {
        if (StringUtils.isNotBlank(key)) {
//            if (StringUtils.isBlank(allowedUserRole) || key.equals(allowedUserRole)) {
            return true;
//            }
        }
        return false;
    }

    public HttpServletRequest getAppRequest() {
        return apprequest;
    }

    public void setAppRequest(HttpServletRequest request) {
        apprequest = request;
    }

    public String getIPFromRequest(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotBlank(ipAddress) && ipAddress.contains(",")) {
            ipAddress = ipAddress.split(",")[0];
        }
        if (StringUtils.isNotBlank(ipAddress) && ipAddress.length() > 15) {
            ipAddress = ipAddress.substring(0, 14);
        }
        if (StringUtils.isBlank(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        if (StringUtils.isBlank(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
}
