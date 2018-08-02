package com.monkey.ele.administrator.service;

import com.monkey.ele.administrator.pojo.Store;

import java.util.List;

public interface StoreService {

    public Store addStore(Store store);

    public int updateCurrentAuditStatus(String id, Integer status);

    public List<Store> findAvailableStores();



}
