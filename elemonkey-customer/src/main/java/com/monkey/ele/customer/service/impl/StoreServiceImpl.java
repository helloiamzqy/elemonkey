package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.StoreDao;
import com.monkey.ele.customer.pojo.Store;
import com.monkey.ele.customer.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/3/2018 7:17 PM
 **/
@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired private StoreDao storeDao;

    @Override
    public List<Store> findHotStoreLimit(int limit) {
        return storeDao.findHotStoreLimit(limit);
    }

}
