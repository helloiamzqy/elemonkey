package com.monkey.ele.customer.service;

import com.monkey.ele.customer.pojo.User;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 10:39 AM
 **/
public interface UserService {

    User findUserByUsername(String username);
    User save(User user);
    User findUserById(String userId);
    User updateUser(User user);

}
