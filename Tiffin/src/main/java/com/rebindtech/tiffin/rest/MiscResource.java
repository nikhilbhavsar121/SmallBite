/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.rest;

import com.rebindtech.tiffin.ctrl.CtrlCollection;
import com.rebindtech.tiffin.ctrl.MiscCtrl;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mrsagar
 */
@Path("misc")
public class MiscResource extends AppResource {

    @Context
    private UriInfo context;

    MiscCtrl miscCtrl;

    /**
     * Creates a new instance of CustomerResource
     */
    /**
     * Creates a new instance of MiscResource
     */
    public MiscResource() {
        this.miscCtrl = CtrlCollection.MISC_CTRL;
    }

    /**
     * Retrieves representation of an instance of
     * com.rebindtech.tiffin.rest.MiscResource
     *
     * @param data
     * @param appType
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/sendUserNotification")
    @Produces(MediaType.APPLICATION_JSON)
    public String sendNotificationToUsers(@FormParam("data") String data, @FormParam("appType") String appType) {
        setHeaders();
        miscCtrl.setAppRequest(request);
        String sendNotificationToUsersString = miscCtrl.sendNotificationToUsers(data, appType);
        return sendNotificationToUsersString;
    }

    @GET
    @Path("/getCity")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCity() {
        String getCityResponse = miscCtrl.getCity();
        return getCityResponse;
    }
    
    @GET
    @Path("/offers")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOffers(){
        String getOffersResponse=miscCtrl.getOffers();
        return getOffersResponse;
    }
    
    @GET
    @Path("/getNotice")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNotice(){
        String getNotice = miscCtrl.getNotice();
        return getNotice;
    }
    
    @GET
    @Path("/getAppVerion")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAppVerion(){
        String getNotice = miscCtrl.getAppVerion();
        return getNotice;
    }
}
