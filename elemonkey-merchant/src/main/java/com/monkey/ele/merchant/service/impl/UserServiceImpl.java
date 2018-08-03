package com.monkey.ele.merchant.service.impl;

import com.monkey.ele.common.util.Md5Utils;
import com.monkey.ele.merchant.dao.UserDao;
import com.monkey.ele.merchant.pojo.User;
import com.monkey.ele.merchant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User saveUser(User user) {
        if(userDao.findByUserName(user) == null){
            user.setType(User.UserType.MERCHANT);
            if(user.getPassword() != null){
                user.setPassword(Md5Utils.md5Password(user.getPassword()));
            }
            User addUser = userDao.add(user);
            addUser.setContacts(null);
            addUser.setOrders(null);
            addUser.setComplains(null);
            return addUser;
        }
        return null;
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        if(user.getPassword() != null){
            user.setPassword(Md5Utils.md5Password(user.getPassword()));
        }
        User updateUser = userDao.update(user);
        updateUser.setContacts(null);
        updateUser.setOrders(null);
        updateUser.setComplains(null);
        return updateUser;
    }

    @Override
    @Transactional
    public void deleteUser(String id) {
        userDao.delete(id);
    }

    @Override
    public User loadUser(String id) {
        User user = userDao.load(id);
        user.setContacts(null);
        user.setOrders(null);
        user.setComplains(null);
        user.setPassword(null);
        return user;
    }




}
