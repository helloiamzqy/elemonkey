package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.StoreDao;
import com.monkey.ele.customer.pojo.Contact;
import com.monkey.ele.customer.pojo.Store;

import java.util.List;

public class StoreDaoImpl extends AbstractBaseDao<Store> implements StoreDao{

    private static final String PASS_STATUS = "1";

    @Override
    public List<Store> findPassStore() {
        String findPassStore = "From Store s where s.currentAuditStatus = ?";
        return this.find(findPassStore,PASS_STATUS);
    }
}
