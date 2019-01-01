package com.rebindtech.tiffin.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

/**
 *
 * @author Sagar
 */
public class AppResource {

    @Context
    HttpServletResponse response;

    @Context
    HttpServletRequest request;

    protected void setHeaders() {
        response.addHeader("Access-Control-Allow-Origin", "*");
    }
}
