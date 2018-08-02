package com.monkey.ele.merchant.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.merchant.pojo.User;

public interface UserDao extends BaseDao<User> {

    User findByUserName(User user);
}
