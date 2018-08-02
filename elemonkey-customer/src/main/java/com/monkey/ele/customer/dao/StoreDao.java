package com.monkey.ele.customer.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.customer.pojo.Store;
import com.monkey.ele.customer.pojo.User;

import java.util.List;

public interface StoreDao  extends BaseDao<Store> {

    public List<Store> findPassStore();
}
