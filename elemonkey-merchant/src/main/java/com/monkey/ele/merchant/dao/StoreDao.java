package com.monkey.ele.merchant.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.merchant.pojo.Store;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 9:21 AM 8/2/2018
 */
public interface StoreDao extends BaseDao<Store> {
    public Store findByUserId(String userId);
}
