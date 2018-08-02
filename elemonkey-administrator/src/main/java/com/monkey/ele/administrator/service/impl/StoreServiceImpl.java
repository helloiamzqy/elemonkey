package com.monkey.ele.administrator.service.impl;

import com.monkey.ele.administrator.dao.StoreDao;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    @Transactional
    @Override
    public Store addStore(Store store) {
        return storeDao.add(store);
    }


    @Transactional
    @Override
    public int updateCurrentAuditStatus(String id, Integer status) {
        return storeDao.updateCurrentAuditStatus(id,status);
    }

    @Override
    public List<Store> findAvailableStores() {
        List<Store> stores = storeDao.findAvailableStores();
        for (Store store: stores) {
            store.setOrders(null);
            store.setProducts(null);
        }
        return stores;
    }

}
