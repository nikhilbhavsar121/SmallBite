package com.rebindtech.tiffin.rest;

import com.rebindtech.tiffin.ctrl.CtrlCollection;
import com.rebindtech.tiffin.ctrl.LoginCtrl;
import java.math.BigInteger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import org.apache.commons.lang3.StringUtils;

/**
 * REST Web Service
 *
 * @author Sagar
 */
@Path("login")
public class LoginResource extends AppResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    LoginCtrl loginCtrl;

    public LoginResource() {
        loginCtrl = CtrlCollection.LOGIN_CTRL;
    }

    @POST
    @Path("/")
    @Produces("application/json")
    public String validateCredentials(@FormParam("userName") BigInteger userName,
            @FormParam("password") String password) {
        setHeaders();
        loginCtrl.setAppRequest(request);
        String validateUserResponse;
        if (StringUtils.isBlank(password)) {
            validateUserResponse = loginCtrl.findUser(userName);
        } else {
            validateUserResponse = loginCtrl.validateUser(userName, password);
        }
        return validateUserResponse;
    }

    /**
     * Retrieves representation of an instance of
     * com.i2rtech.tiffin.rest.LoginResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of LoginResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @POST
    @Path("/changePasswrd")
    public String changePassword(@FormParam("userID") Integer userID,@FormParam("password") String password){
         String addFeedbackResponse = loginCtrl.changePassword(userID,password);
        return addFeedbackResponse;
    }
}
