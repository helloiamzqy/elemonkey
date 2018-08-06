package com.monkey.ele.administrator.dao;

import com.monkey.ele.administrator.pojo.User;
import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.common.security.service.AuthorizeUserDao;

import java.util.List;

public interface UserDao extends BaseDao<User>, AuthorizeUserDao {

    User findUserByUsername(String username);

    List<User> findUsersByUserIds(List<String> userIds);
}
