/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.ctrl;

/**
 *
 * @author mrsagar
 */
public interface MiscCtrl extends AuthenticationCtrl {

    public String sendNotificationToUsers(String data, String appType);

    public String getCity();

    public String getOffers();

    public String getNotice();

    public String getAppVerion();

}
