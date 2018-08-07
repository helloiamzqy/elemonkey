package com.monkey.ele.merchant.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.common.security.service.AuthorizeUserDao;
import com.monkey.ele.merchant.pojo.User;

public interface UserDao extends BaseDao<User>, AuthorizeUserDao {

    User findByUserName(User user);

    User findUserByUsername(String username);
}
