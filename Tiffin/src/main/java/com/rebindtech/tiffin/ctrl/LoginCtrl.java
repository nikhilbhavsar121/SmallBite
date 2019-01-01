/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.ctrl;

import java.math.BigInteger;

/**
 *
 * @author mrsagar
 */
public interface LoginCtrl extends AuthenticationCtrl{

    public String findUser(BigInteger userName);

    public String validateUser(BigInteger userName, String password);

    public String changePassword(Integer userID, String password);

}
