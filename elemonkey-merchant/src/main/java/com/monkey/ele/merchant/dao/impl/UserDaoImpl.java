package com.monkey.ele.merchant.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.merchant.dao.UserDao;
import com.monkey.ele.merchant.pojo.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao {

   @Override
   public User findByUserName(User user){
       List<User> users = this.find("SELECT u FROM User u WHERE u.username = ?", user.getUsername());
       if(users.size() > 0){
           return users.get(0);
       }
       return null;
   }

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
