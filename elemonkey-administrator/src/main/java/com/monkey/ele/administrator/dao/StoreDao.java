package com.monkey.ele.administrator.dao;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.common.dao.BaseDao;

import java.util.List;

public interface StoreDao extends BaseDao<Store>{

    public int updateCurrentAuditStatus(String id, Integer status);

    public List<Store> findAvailableStores();



}
