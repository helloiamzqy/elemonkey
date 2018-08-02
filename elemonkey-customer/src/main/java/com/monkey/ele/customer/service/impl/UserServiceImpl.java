package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.UserDao;
import com.monkey.ele.customer.pojo.User;
import com.monkey.ele.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 2:56 PM
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean isExists(String username) {
        return userDao.findUserByUsername(username) != null;
    }

    @Override
    public boolean validate(String username, String password) {
        User user = userDao.findUserByUsername(username);
        if (user == null)
            return false;
        return user.getPassword().equals(password);
    }

}
