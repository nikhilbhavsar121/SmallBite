/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rebindtech.tiffin.service;

import com.rebindtech.tiffin.auth.LoggedInUser;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import java.math.BigInteger;
import javax.ejb.Local;

/**
 *
 * @author mrsagar
 */
@Local
public interface LoginService {

    public MessageDTO findUser(BigInteger userName);

    public MessageDTO validateUser(BigInteger userName, String password);

    public LoggedInUser getLoggedInUser();

    public MessageDTO changePassword(Integer userID, String password);
    
}
