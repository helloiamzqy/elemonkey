package com.monkey.ele.customer.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.customer.pojo.Store;

import java.util.List;

public interface StoreDao extends BaseDao<Store> {

    public List<Store> findStoresByPage(Integer firstIndex,Integer maxResults);

    public Integer countStoresPage();


}
