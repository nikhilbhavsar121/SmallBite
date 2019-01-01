package com.rebindtech.tiffin.rest;

import com.rebindtech.tiffin.ctrl.CtrlCollection;
import com.rebindtech.tiffin.ctrl.MobileDeviceCtrl;
import com.rebindtech.tiffin.dto.MobileDeviceDTO;
import com.rebindtech.tiffin.utils.JsonConverter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author Sagar
 */
@Path("mobileDevice")
public class MobileDeviceResource {

    @Context
    private UriInfo context;

    public MobileDeviceResource() {
    }

    @POST
    @Produces("application/json")
    @Path("/addDevice")
    public String getJson(String deviceJSON) {
        MobileDeviceCtrl mobileDeviceCtrl = CtrlCollection.MOBILE_DEVICE_CTRL;
        MobileDeviceDTO mobileDeviceDTO = (MobileDeviceDTO) JsonConverter.fromJsonToDTO(deviceJSON, MobileDeviceDTO.class);
        String getJsonString = mobileDeviceCtrl.addMobileDevice(mobileDeviceDTO);
        return getJsonString;
    }

}
