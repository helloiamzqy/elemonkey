package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.StoreDao;
import com.monkey.ele.customer.pojo.Store;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StoreDaoImpl extends AbstractBaseDao<Store> implements StoreDao {
    @Override
    public List<Store> findStoresByPage(Integer firstIndex, Integer maxResults) {
        String jpql="from Store where currentAuditStatus = ? and status = ? order by createTime desc";
        return this.findPage(firstIndex, maxResults, jpql, Store.StoreAuditStatus.ACCEPT, Store.StoreStatus.NORMAL);
    }

    @Override
    public Integer countStoresPage() {
        String jpql = "select count(*) from Store where currentAuditStatus = ? and status = ?";
        return this.count(jpql, Store.StoreAuditStatus.ACCEPT, Store.StoreStatus.NORMAL);
    }
}
