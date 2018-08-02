package com.monkey.ele.customer.service;

import com.monkey.ele.common.security.service.AuthorizeUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 10:39 AM
 **/
public class UserService implements AuthorizeUserService {

    @Autowired private UserDao

    @Override
    public boolean isExists(String username) {
        return true;
    }

    @Override
    public boolean validate(String username, String password) {
        return true;
    }

}
