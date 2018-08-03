package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.ComplexStoreDao;
import com.monkey.ele.customer.pojo.ComplexStore;
import com.monkey.ele.customer.service.ComplexStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComplexStoreServiceImpl implements ComplexStoreService {

    @Autowired
    ComplexStoreDao storeDao;

    @Transactional
    @Override
    public List<ComplexStore> findPassStore() {
        return storeDao.findPassStore();
    }

    @Transactional
    @Override
    public List<ComplexStore> findPassStorePage(Integer firstIndex, Integer maxResults) {
        return storeDao.findPassStorePage(firstIndex,maxResults);
    }
}
