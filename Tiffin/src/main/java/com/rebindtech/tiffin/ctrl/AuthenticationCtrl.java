package com.rebindtech.tiffin.ctrl;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Sagar
 */
public interface AuthenticationCtrl {

    public void setAppRequest(HttpServletRequest request);

    public HttpServletRequest getAppRequest();
}
