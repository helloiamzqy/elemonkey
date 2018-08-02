package com.monkey.ele.merchant.service.impl;

import com.monkey.ele.common.jms.JmsSender;
import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.util.JsonUtil;
import com.monkey.ele.merchant.dao.StoreDao;
import com.monkey.ele.merchant.dao.StoreInformationDao;
import com.monkey.ele.merchant.pojo.*;
import com.monkey.ele.merchant.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Map;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 9:28 AM 8/2/2018
 */
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreDao storeDao;
    @Autowired
    StoreInformationDao storeInfoDao;
    @Autowired
    JmsSender jmsSender;

    @Override
    @Transactional
    public Store applyStore(Store store) throws Exception {
        sendStoreRequest(store);
        return storeDao.add(store);
    }

    @Override
    public Store watchStore(String storeId) {
        Store store = storeDao.load(storeId);
        store.setOrders(null);
        store.setProducts(null);
        store.setStoreInformation(null);
        store.setUser(null);
        return store;
    }

    @Override
    public StoreInformation watchStoreInfo(String storeId) {
        Store store = storeDao.load(storeId);
        return store.getStoreInformation();
    }

    @Override
    @Transactional
    public Store modifyStore(Store store) {
        return storeDao.update(store);
    }

    @Override
    @Transactional
    public StoreInformation modifyStoreInfo(String storeId, StoreInformation storeInfo) {
        Store store = storeDao.load(storeId);
        store.setStoreInformation(storeInfo);
        storeDao.update(store);
        return store.getStoreInformation();
    }

    private void sendStoreRequest(Store store) throws Exception {
        JMail jMail = new JMail();
        jMail.setMessageType(JMail.JMailType.STORE_REQUEST);
        jMail.setMessage(store);
        jmsSender.sendTextMessage(JsonUtil.obj2json(store));
    }

}
