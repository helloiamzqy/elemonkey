package com.monkey.ele.customer.service;

import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.customer.pojo.Store;

import java.util.List;

public interface StoreService {
    public Page<Store> findStoresByPage(Page page);
}
