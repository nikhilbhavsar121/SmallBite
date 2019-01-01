/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rebindtech.tiffin.servicebean;

import com.rebindtech.tiffin.auth.LoggedInUser;
import com.rebindtech.tiffin.constants.MsgConstant;
import com.rebindtech.tiffin.constants.QueryConstant;
import com.rebindtech.tiffin.dto.CustomerDTO;
import com.rebindtech.tiffin.dto.core.MessageDTO;
import com.rebindtech.tiffin.entity.LoginMaster;
import com.rebindtech.tiffin.service.CustomerService;
import com.rebindtech.tiffin.service.LoginService;
import com.rebindtech.tiffin.utils.Encryption;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mrsagar
 */
@Stateless
public class LoginServiceBean implements LoginService {

    @PersistenceContext
    EntityManager em;

    @EJB
    CustomerService customerService;

    private LoggedInUser user;

    @Override
    public MessageDTO findUser(BigInteger userName) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            Query query = em.createNativeQuery(QueryConstant.GET_USER_BY_MOBILE_NUMBER)
                    .setParameter("smsPhone", userName);
            List<Object> customers = query.getResultList();
            if (!customers.isEmpty()) {
                messageDTO.setMessageID(MsgConstant.USER_FOUND_ID);
                messageDTO.setMessageText(MsgConstant.USER_FOUND_TEXT);
            } else {
                messageDTO.setMessageID(MsgConstant.USER_NOT_FOUND_ID);
                messageDTO.setMessageText(MsgConstant.USER_NOT_FOUND_TEXT);
            }
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.USER_NOT_FOUND_ID);
            messageDTO.setMessageText(MsgConstant.USER_NOT_FOUND_TEXT);
        }
        return messageDTO;
    }

    @Override
    public MessageDTO validateUser(BigInteger userName, String password) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            String encryptedPassword = Encryption.encryptPassword(password);
            Query query = em.createNativeQuery(QueryConstant.GET_USER_BY_USERNAME_PASSWORD, LoginMaster.class)
                    .setParameter("mobileNumber", userName)
                    .setParameter("password", encryptedPassword);
            LoginMaster loginMaster = (LoginMaster) query.getSingleResult();
            if (loginMaster != null) {
                CustomerDTO customerDTO = customerService.getCustomer(loginMaster.getUserID());
                messageDTO.setCustomer(customerDTO);
                LoggedInUser loggedInUser = new LoggedInUser();
                loggedInUser.setUserID(Integer.parseInt(customerDTO.getCustomerID()));
                loggedInUser.setUserName(customerDTO.getFullName());
                loggedInUser.setSmsPhonePrimary(customerDTO.getsMSPhone());
                setLoggedInUser(loggedInUser);
            } else {
                messageDTO.setMessageID(MsgConstant.FAILURE_ID);
                messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
            }
        } catch (NoResultException nre) {
            messageDTO.setMessageID(MsgConstant.LOGIN_FAILED_ID);
            messageDTO.setMessageText(MsgConstant.LOGIN_FAILED_TEXT);
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }

    @Override
    public LoggedInUser getLoggedInUser() {
        if (user != null) {
            return user;
        }
        return new LoggedInUser();
    }

    private void setLoggedInUser(LoggedInUser loggedInUser) {
        this.user = loggedInUser;
    }

    @Override
    public MessageDTO changePassword(Integer userID, String password) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            String encryptedPassword = Encryption.encryptPassword(password);
            Query query = em.createNativeQuery(QueryConstant.UPDATE_PASSWORD_BY_USER_ID)
                    .setParameter("userID", userID)
                    .setParameter("password", encryptedPassword);
            query.executeUpdate();
            messageDTO.setMessageID(MsgConstant.SUCCESS_ID);
            messageDTO.setMessageText(MsgConstant.SUCCESS_TEXT);
        } catch (Exception e) {
            messageDTO.setMessageID(MsgConstant.FAILURE_ID);
            messageDTO.setMessageText(MsgConstant.FAILURE_TEXT);
        }
        return messageDTO;
    }
}
