package com.monkey.ele.customer.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.customer.pojo.User;
/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 2:14 PM
 **/
public interface UserDao extends BaseDao<User> {

    User findUserByUsername(String username);

}
