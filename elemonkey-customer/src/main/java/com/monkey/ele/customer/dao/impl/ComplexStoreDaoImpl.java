package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.ComplexStoreDao;
import com.monkey.ele.customer.pojo.ComplexStore;
import com.monkey.ele.customer.pojo.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComplexStoreDaoImpl extends AbstractBaseDao<ComplexStore> implements ComplexStoreDao {

    private static final int PASS_STATUS = 1;


    @Override
    public List<ComplexStore> findPassStore() {
        String findPassStore = "Select new com.monkey.ele.customer.pojo.ComplexStore(s.id,s.name,s.storeInformation)" +
                " From Store s where s.currentAuditStatus = ?";
        return this.find(findPassStore,PASS_STATUS);
    }

    @Override
    public List<ComplexStore> findPassStorePage(Integer firstIndex, Integer maxResults) {
        String findPassStore = "Select new com.monkey.ele.customer.pojo.ComplexStore(s.id,s.name,s.storeInformation)" +
                " From Store s where s.currentAuditStatus = ?";
        return this.findPage(firstIndex, maxResults,findPassStore,PASS_STATUS);
    }

    @Override
    public List<ComplexStore> findHotStore(int limit) {
        return this.findPage(0, limit, "Select new com.monkey.ele.customer.pojo.ComplexStore(s.id,s.name,s.storeInformation) from Store s where s.currentAuditStatus = ? order by s.orders.size desc", Store.StoreAuditStatus.ACCEPT);
    }

}
