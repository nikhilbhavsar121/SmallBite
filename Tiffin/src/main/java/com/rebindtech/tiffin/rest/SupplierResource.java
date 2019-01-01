package com.rebindtech.tiffin.rest;

import com.rebindtech.tiffin.ctrl.CtrlCollection;
import com.rebindtech.tiffin.ctrl.SupplierCtrl;
import com.rebindtech.tiffin.dto.SubsMenuDTO;
import com.rebindtech.tiffin.dto.SupplierDTO;
import com.rebindtech.tiffin.dto.TiffinDTO;
import com.rebindtech.tiffin.dto.TiffinMenusDTO;
import com.rebindtech.tiffin.utils.JsonConverter;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Sagar
 */
@Path("supplier")
public class SupplierResource extends AppResource {

    @Context
    private UriInfo context;

    private final SupplierCtrl supplierCtrl;

    /**
     * Creates a new instance of SupplierResource
     */
    public SupplierResource() {
        supplierCtrl = CtrlCollection.SUPPLIER_CTRL;
    }

    @POST
    @Path("/addSupplier")
    @Produces(MediaType.APPLICATION_JSON)
    public String addSupplier(@FormParam("addSupplier") String supplierJSON) {
        SupplierDTO supplierDTO = (SupplierDTO) JsonConverter.fromJsonToDTO(supplierJSON, SupplierDTO.class);
        String addSupplierResponse = supplierCtrl.addSupplier(supplierDTO);
        return addSupplierResponse;
    }

    @POST
    @Path("/getSupplier")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSuppllier(@FormParam("lattitude") String lattitude, @FormParam("longitude") String longitude) {
        setHeaders();
        supplierCtrl.setAppRequest(request);
        String getSupplierResponse = supplierCtrl.getSuppllier(lattitude, longitude);
        return getSupplierResponse;
    }

    @GET
    @Path("/getTiffin")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTiffin(@QueryParam("supplierID") String supplierIDs,
            @QueryParam("isToday") Boolean isToday, @QueryParam("isLunch") Boolean isLunch) {
        setHeaders();
        String getSupplierResponse = supplierCtrl.getTiffin(supplierIDs, isToday,isLunch);
        return getSupplierResponse;
    }

    @POST
    @Path("/addTiffin")
    @Produces(MediaType.APPLICATION_JSON)
    public String addTiffin(String addTiffinJSON) {
        TiffinDTO tiffinDTO = (TiffinDTO) JsonConverter.fromJsonToDTO(addTiffinJSON, TiffinDTO.class);
        String addTiffinResponse = supplierCtrl.addTiffin(tiffinDTO);
        return addTiffinResponse;
    }

    @POST
    @Path("/addSubsMenu")
    @Produces(MediaType.APPLICATION_JSON)
    public String addSubsMenu(String subsmenuString) {
        SubsMenuDTO subsMenuDTO = (SubsMenuDTO) JsonConverter.fromJsonToDTO(subsmenuString, SubsMenuDTO.class);
        String addSubsMenuString = supplierCtrl.addSubsMenu(subsMenuDTO);
        return addSubsMenuString;
    }

    @GET
    @Path("/getSubsMenu")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSubsMenu(@FormParam("supplierID") Integer supplierID) {
        String getSubsMenuResponse = supplierCtrl.getSubsMenu(supplierID);
        return getSubsMenuResponse;
    }

    @POST
    @Path("/addTiffinMenu")
    @Produces(MediaType.APPLICATION_JSON)
    public String addTiffinMenu(String tiffinMenuString) {
        TiffinMenusDTO tiffinMenusDTO = (TiffinMenusDTO) JsonConverter.fromJsonToDTO(tiffinMenuString, TiffinMenusDTO.class);
        String addTiffinMenuString = supplierCtrl.addTiffinMenu(tiffinMenusDTO);
        return addTiffinMenuString;
    }

    @GET
    @Path("/getAddOns")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAddOns() {
        String getAddOnsResponse = supplierCtrl.getAddOns();
        return getAddOnsResponse;

    }

    @GET
    @Path("/myOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMyOrders(@QueryParam("supplierID") Integer supplierID,
            @QueryParam("orderDate") String orderDate) {
        String getMyOrdersResponse = supplierCtrl.getMyOrders(supplierID,orderDate);
        return getMyOrdersResponse;
    }
}
