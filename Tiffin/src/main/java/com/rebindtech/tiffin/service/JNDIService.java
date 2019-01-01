package com.rebindtech.tiffin.service;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Sagar
 */
public abstract class JNDIService {

    public final static CustomerService getCustomerService() {
        CustomerService customerService = null;
        try {
            Context context = getInitialContext();
            customerService = (CustomerService) context.lookup("java:global/Tiffin/CustomerServiceBean");
        } catch (NamingException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerService;
    }

    public final static SupplierService getSupplierService() {
        SupplierService supplierService = null;
        try {
            Context context = getInitialContext();
            supplierService = (SupplierService) context.lookup("java:global/Tiffin/SupplierServiceBean");
        } catch (NamingException ex) {
            Logger.getLogger(SupplierService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplierService;
    }

    public final static LoginService getLoginService() {
        LoginService loginService = null;
        try {
            Context context = getInitialContext();
            loginService = (LoginService) context.lookup("java:global/Tiffin/LoginServiceBean");
        } catch (NamingException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loginService;
    }

    public final static OrderService getOrderService() {
        OrderService orderService = null;
        try {
            Context context = getInitialContext();
            orderService = (OrderService) context.lookup("java:global/Tiffin/OrderServiceBean");
        } catch (NamingException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderService;
    }

    public final static MobileDeviceService getMobileDeviceService() {
        MobileDeviceService mobileDeviceService = null;
        try {
            Context context = getInitialContext();
            mobileDeviceService = (MobileDeviceService) context.lookup("java:global/Tiffin/MobileDeviceServiceBean");
        } catch (NamingException ex) {
            Logger.getLogger(MobileDeviceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mobileDeviceService;
    }

    public final static MiscService getMiscService() {
        MiscService miscService = null;
        try {
            Context context = getInitialContext();
            miscService = (MiscService) context.lookup("java:global/Tiffin/MiscServiceBean");
        } catch (NamingException ex) {
            Logger.getLogger(MiscService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miscService;
    }

    private static Context getInitialContext() {
        Hashtable propertis = new Hashtable();
        propertis.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        propertis.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
        propertis.put(Context.PROVIDER_URL, "jnp://localhost:1099");
        Context ctx = null;
        try {
            ctx = new InitialContext();//(propertis);
        } catch (NamingException ex) {
            Logger.getLogger(JNDIService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctx;
    }
}
