package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.CommentDao;
import com.monkey.ele.customer.dao.ComplexStoreDao;
import com.monkey.ele.customer.pojo.ComplexStore;
import com.monkey.ele.customer.service.ComplexStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComplexStoreServiceImpl implements ComplexStoreService {

    @Autowired
    ComplexStoreDao storeDao;
    @Autowired
    CommentDao commentDao;

    @Transactional
    @Override
    public List<ComplexStore> findPassStore() {
        return storeDao.findPassStore();
    }

    @Transactional
    @Override
    public List<ComplexStore> findPassStorePage(Integer firstIndex, Integer maxResults) {
        return storeDao.findPassStorePage(firstIndex, maxResults);
    }

    @Override
    public Double watchStoreRank(String storeId) {
        Double rank = commentDao.findStoreRank(storeId);
        return rank;
    }

    @Override
    public List<ComplexStore> findHotStore(int limit) {
        return storeDao.findHotStore(limit);
    }

}
