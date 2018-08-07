package com.monkey.ele.administrator.dao.impl;

import com.monkey.ele.administrator.dao.UserDao;
import com.monkey.ele.administrator.pojo.User;
import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findUserByUsername(String username) {
        return load("from User u where u.username = ?", username);
    }

    @Override
    public List<User> findUsersByUserIds(List<String> userIds) {
        return  em.createQuery("from User where id in (:userIds)").setParameter("userIds",userIds).getResultList();
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
