/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.servicebean;

import com.rebindtech.tiffin.entity.SMSLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author mrsagar
 */
public class SMSClient {

    public static String retval = "";

    public static String sendSMS(SMSLog sMSLog) {
        //Your authentication key
        String authkey = "101792AKw5LzNdFK8c568b9175";
//Multiple mobiles numbers separated by comma
        String mobiles = sMSLog.getSMSNumber().toString();
//Sender ID,While using route4 sender id should be 6 characters long.
        String senderId = "SMBITE";
//Your message to send, Add URL encoding here.
        String message = sMSLog.getSMSText();
//define route
        String route = "template";

//Prepare Url
        URLConnection myURLConnection = null;
        URL myURL = null;
        BufferedReader reader = null;

//encoding message 
        String encoded_message = URLEncoder.encode(message);

//Send SMS API
        String mainUrl = "http://api.msg91.com/api/sendhttp.php?";

//Prepare parameter string 
        StringBuilder sbPostData = new StringBuilder(mainUrl);
        sbPostData.append("authkey=" + authkey);
        sbPostData.append("&mobiles=" + mobiles);
        sbPostData.append("&message=" + encoded_message);
        sbPostData.append("&route=" + route);
        sbPostData.append("&sender=" + senderId);

//final string
        mainUrl = sbPostData.toString();
        try {
            //prepare connection
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            //reading response 
            String response;
            while ((response = reader.readLine()) != null) //print response 
            {
                System.out.println(response);
            }

            //finally close connection
            reader.close();
        } catch (IOException e) {
        }
        return null;
    }

    public static String sendAdminSMS(String smsText) {
        //Your authentication key
        String authkey = "101792AKw5LzNdFK8c568b9175";
//Multiple mobiles numbers separated by comma
        String mobiles = "9545059400";
//Sender ID,While using route4 sender id should be 6 characters long.
        String senderId = "SMBITE";
//Your message to send, Add URL encoding here.
        String message = smsText;
//define route
        String route = "template";

//Prepare Url
        URLConnection myURLConnection = null;
        URL myURL = null;
        BufferedReader reader = null;

//encoding message 
        String encoded_message = URLEncoder.encode(message);

//Send SMS API
        String mainUrl = "http://api.msg91.com/api/sendhttp.php?";

//Prepare parameter string 
        StringBuilder sbPostData = new StringBuilder(mainUrl);
        sbPostData.append("authkey=" + authkey);
        sbPostData.append("&mobiles=" + mobiles);
        sbPostData.append("&message=" + encoded_message);
        sbPostData.append("&route=" + route);
        sbPostData.append("&sender=" + senderId);

//final string
        mainUrl = sbPostData.toString();
        try {
            //prepare connection
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            //reading response 
            String response;
            while ((response = reader.readLine()) != null) //print response 
            {
                System.out.println(response);
            }

            //finally close connection
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
