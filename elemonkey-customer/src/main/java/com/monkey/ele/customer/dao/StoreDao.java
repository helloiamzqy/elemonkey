package com.monkey.ele.customer.dao;

import com.monkey.ele.common.dao.BaseDao;

import com.monkey.ele.customer.pojo.Store;

import java.util.List;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/3/2018 7:14 PM
 **/
public interface StoreDao extends BaseDao<Store> {

    List<Store> findHotStoreLimit(int limit);

    List<Store> findPassStorePage(Integer firstIndex, Integer maxResults);

    List<Store> findPassStore();


}
