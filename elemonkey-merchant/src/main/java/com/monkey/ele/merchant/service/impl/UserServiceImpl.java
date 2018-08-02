package com.monkey.ele.merchant.service.impl;

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
        List<User> users = userDao.find("SELECT u FROM User u WHERE u.username = :username", user.getUsername());
        if(users.size() > 0){
            return null;
        }
        User addUser = userDao.add(user);
        return addUser;
    }

    @Override
    public User updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.delete(id);
    }

    @Override
    public User loadUser(String id) {
        return userDao.load(id);
    }




}
