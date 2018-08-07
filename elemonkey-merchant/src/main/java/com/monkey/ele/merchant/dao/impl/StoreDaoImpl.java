package com.monkey.ele.merchant.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.merchant.dao.StoreDao;
import com.monkey.ele.merchant.pojo.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 9:07 AM 8/2/2018
 */
@Repository
public class StoreDaoImpl extends AbstractBaseDao<Store> implements StoreDao {

    @Override
    public Store findByUserId(String userId) {
        List<Store> stores =  this.find("from Store s where s.user.id = ?", userId);
        if(stores == null || stores.size() == 0){
            return null;
        }
        return stores.get(0);
    }
}
