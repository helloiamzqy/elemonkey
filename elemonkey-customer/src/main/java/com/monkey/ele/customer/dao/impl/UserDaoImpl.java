package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.UserDao;
import com.monkey.ele.customer.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 2:18 PM
 **/
@Repository
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao {

    @Override
    public User findUserByUsername(String username) {
        return load("from User u where u.username = ?", username);
    }

}
