/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.ctrlimpl;

import com.rebindtech.tiffin.auth.LoggedInUser;
import com.rebindtech.tiffin.auth.Authentication;
import com.rebindtech.tiffin.constants.AppConstant;
import com.rebindtech.tiffin.ctrl.LoginCtrl;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.service.JNDIService;
import com.rebindtech.tiffin.service.LoginService;
import com.rebindtech.tiffin.utils.JsonConverter;
import java.math.BigInteger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mrsagar
 */
public class LoginCtrlImpl extends Authentication implements LoginCtrl {

    LoginService loginService = JNDIService.getLoginService();

    @Override
    public String findUser(BigInteger userName) {
        MessageDTO messageDTO = loginService.findUser(userName);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String validateUser(BigInteger userName, String password) {
        MessageDTO messageDTO = loginService.validateUser(userName, password);
        if (messageDTO.getCustomer() != null) {
            HttpSession session = getAppRequest().getSession();
            LoggedInUser user = loginService.getLoggedInUser();
            session.setAttribute(AppConstant.LOGGED_IN_USER, user);
        }
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

    @Override
    public String changePassword(Integer userID, String password) {
        MessageDTO messageDTO = loginService.changePassword(userID, password);
        return JsonConverter.createJsonFromDTO(messageDTO);
    }

}
