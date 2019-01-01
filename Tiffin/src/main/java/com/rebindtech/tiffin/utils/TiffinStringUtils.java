package com.rebindtech.tiffin.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sagar
 */
public class TiffinStringUtils {

    public static String createTpin(Integer length) {

        char[] chars = "1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static String createRandomString(Integer length) {
        char[] chars = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static List<Integer> getCommaSeperatedValuesFromString(String list) {
        String arr[] = list.split(",");
        List<Integer> supplierIDs = new ArrayList<Integer>();
        for (String s : arr) {
            supplierIDs.add(Integer.parseInt(s));
        }
        return supplierIDs;
    }

}
