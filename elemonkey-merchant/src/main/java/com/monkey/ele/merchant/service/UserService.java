package com.monkey.ele.merchant.service;

import com.monkey.ele.merchant.pojo.User;

public interface UserService {
    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(String id);


    User loadUser(String id);
}
