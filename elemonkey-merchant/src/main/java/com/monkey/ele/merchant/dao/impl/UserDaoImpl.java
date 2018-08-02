package com.monkey.ele.merchant.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.merchant.dao.UserDao;
import com.monkey.ele.merchant.pojo.User;
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
}
