package com.monkey.ele.customer.service.impl;

import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.customer.dao.StoreDao;
import com.monkey.ele.customer.pojo.Store;
import com.monkey.ele.customer.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    @Override
    public Page<Store> findStoresByPage(Page page){
        page.setItemTotal(storeDao.countStoresPage());
        List<Store> stores = storeDao.findStoresByPage(page.getFirstIndex(),page.getPageCount());
        page.setItems(stores);
        return page;
    }
}

