package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.UserDao;
import com.monkey.ele.customer.pojo.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
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

    @Override
    public boolean isExists(String username) {
        return this.findUserByUsername(username) != null;
    }

    @Override
    public boolean validate(String username, String password) {
        User user = this.findUserByUsername(username);
        if (user == null)
            return false;
        return user.getPassword().equals(password);
    }

    @Override
    public SimpleAuthenticationInfo createAuthenticationInfo(String username, String realmName) {
        User user = this.findUserByUsername(username);
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), realmName);
        }
        return null;
    }

}
