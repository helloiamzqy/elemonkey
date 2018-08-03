package com.monkey.ele.administrator.dao.impl;

import com.monkey.ele.administrator.dao.UserDao;
import com.monkey.ele.administrator.pojo.User;
import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao {
}
