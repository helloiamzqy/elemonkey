package com.monkey.ele.administrator.service.impl;

import com.monkey.ele.administrator.dao.UserDao;
import com.monkey.ele.administrator.pojo.User;
import com.monkey.ele.administrator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User addUser(User user) {
        return userDao.add(user);
    }
}
