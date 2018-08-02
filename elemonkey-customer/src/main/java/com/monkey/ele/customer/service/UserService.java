package com.monkey.ele.customer.service;

import com.monkey.ele.common.security.service.AuthorizeUserService;
import com.monkey.ele.customer.pojo.User;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 10:39 AM
 **/
public interface UserService extends AuthorizeUserService {

    User findUserByUsername(String username);

}
