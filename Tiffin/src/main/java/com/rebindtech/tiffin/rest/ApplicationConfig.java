/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rebindtech.tiffin.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author mrsagar
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.rebindtech.tiffin.rest.CustomerResource.class);
        resources.add(com.rebindtech.tiffin.rest.LoginResource.class);
        resources.add(com.rebindtech.tiffin.rest.MiscResource.class);
        resources.add(com.rebindtech.tiffin.rest.MobileDeviceResource.class);
        resources.add(com.rebindtech.tiffin.rest.OrderResource.class);
        resources.add(com.rebindtech.tiffin.rest.SupplierResource.class);
    }
    
}
