package com.rebindtech.tiffin.rest;

import com.rebindtech.tiffin.ctrl.CtrlCollection;
import com.rebindtech.tiffin.ctrl.CustomerCtrl;
import com.rebindtech.tiffin.dto.AddressMasterDTO;
import com.rebindtech.tiffin.utils.JsonConverter;
import java.math.BigInteger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Sagar
 */
@Path("customer")
public class CustomerResource extends AppResource {

    @Context
    private UriInfo context;
    private final CustomerCtrl customerCtrl;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource()
    {
        this.customerCtrl = CtrlCollection.CUSTOMER_CTRL;
    }

    @POST
    @Path("/addCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public String addCustomer(@FormParam("customerID") Integer customerID, @FormParam("fullName") String fullName,
            @FormParam("emailID") String emailID, @FormParam("mobile") BigInteger mobileNumber,
            @FormParam("password") String password, @FormParam("referralCode") String referralCode) {
        String addCustomerResponse = customerCtrl.addCustomer(customerID, fullName, emailID, mobileNumber, password, referralCode);
        return addCustomerResponse;
    }

    @POST
    @Path("/verify")
    @Produces(MediaType.APPLICATION_JSON)
    public String verifyPin(@FormParam("customerID") Integer customerID, @FormParam("pin") String pin,
            @FormParam("type") String type, @FormParam("isForget") Boolean isForget) {
        String verifyPinResponse = customerCtrl.verifyPin(customerID, pin, type, isForget);
        return verifyPinResponse;
    }

    @POST
    @Path("/addAddress")
    @Produces(MediaType.APPLICATION_JSON)
    public String addAddress(String addressJSON) {
        setHeaders();
        customerCtrl.setAppRequest(request);
        AddressMasterDTO addressMasterDTO = (AddressMasterDTO) JsonConverter.fromJsonToDTO(addressJSON, AddressMasterDTO.class);
        String addAddressRespone = customerCtrl.addAddress(addressMasterDTO);
        return addAddressRespone;
    }

    @GET
    @Path("/getAddress")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAddress(@QueryParam("customerID") Integer customerID) {
        setHeaders();
        customerCtrl.setAppRequest(request);
        String getAddressResponse = customerCtrl.getAddress(customerID);
        return getAddressResponse;
    }

    @GET
    @Path("/getCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomer(@QueryParam("customerID") Integer customerID) {
        String getCustomerResponse = customerCtrl.getCustomer(customerID);
        return getCustomerResponse;
    }

    @POST
    @Path("/addDevice")
    @Produces(MediaType.APPLICATION_JSON)
    public String addDeviceID(@FormParam("customerID") Integer customerID,
            @FormParam("deviveID") Integer deviceID) {
        String getAddDeviceIDResponse = customerCtrl.addDeviceID(customerID, deviceID);
        return getAddDeviceIDResponse;
    }

    @POST
    @Path("/reSend")
    @Produces(MediaType.APPLICATION_JSON)
    public String reSendPin(@FormParam("customerID") Integer customerID, @FormParam("mobileNumber") String mobileNumber) {
        String getReSendPinResponse = customerCtrl.reSendPin(customerID, mobileNumber);
        return getReSendPinResponse;
    }
// All Below services are pending from excel list
    @POST
    @Path("/doRecharge")
    @Produces(MediaType.APPLICATION_JSON)
    public String rechargeAccount(@FormParam("customerID") Integer customerID, @FormParam("rechargeAmount") String rechargeAmount,
            @FormParam("rechargeStatus") String rechargeStatus, @FormParam("rechargeMode") String rechargeMode) {
        String rechargeAccountResponse = customerCtrl.rechargeAccount(customerID, rechargeAmount, rechargeStatus, rechargeMode);
        return rechargeAccountResponse;
    }

    @POST
    @Path("/changeRechargeStatus")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateRechargeStatus(@FormParam("rechargeID") Integer rechargeID, @FormParam("rechargeStatus") String status) {
        String updateRechargeStatusResponse = customerCtrl.updateRechargeStatus(rechargeID, status);
        return updateRechargeStatusResponse;
    }

    @POST
    @Path("/feedback")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveFeedback(@FormParam("customerID") Integer customerID, @FormParam("feedback") String feedback) {
        String saveFeedbackString = customerCtrl.saveFeedback(customerID, feedback);
        return saveFeedbackString;
    }

    @POST
    @Path("/getWallet")
    @Produces(MediaType.APPLICATION_JSON)
    public String getWalletBalance(@FormParam("customerID") Integer customerID) {
        String getWalletBalanceString = customerCtrl.getWalletBalance(customerID);
        return getWalletBalanceString;
    }

    @POST
    @Path("/bulkSMS")
    @Produces(MediaType.APPLICATION_JSON)
    public String sendBulkSMS(@FormParam("smsText") String smsText) {
        String sendBulkSMSString = customerCtrl.sendBulkSMS(smsText);
        return sendBulkSMSString;
    }

    @POST
    @Path("/updateLocality")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateLocality(@FormParam("customerID") Integer customerID,
            @FormParam("localityID") Integer localityID) {
        String updateLocalityResponse = customerCtrl.updateLocality(customerID, localityID);
        return updateLocalityResponse;
    }
}
