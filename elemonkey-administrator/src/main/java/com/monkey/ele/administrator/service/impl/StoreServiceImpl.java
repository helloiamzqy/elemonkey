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

    @Override
    public List<Store> findAllStore() {
        return storeDao.findAll();
    }

    @Transactional
    @Override
    public int updateCurrentAuditStatus(String id, Integer status) {
        return storeDao.updateCurrentAuditStatus(id,status);
    }
}
