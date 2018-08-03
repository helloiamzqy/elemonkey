package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.StoreDao;
import com.monkey.ele.customer.pojo.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/3/2018 7:14 PM
 **/
@Repository
public class StoreDaoImpl extends AbstractBaseDao<Store> implements StoreDao {

    @Override
    public List<Store> findHotStoreLimit(int limit) {
        return this.findPage(0, limit, "select s from Store s where s.currentAuditStatus = ? order by s.orders.size desc", Store.StoreAuditStatus.ACCEPT);
    }

}
