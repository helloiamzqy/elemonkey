package com.monkey.ele.administrator.dao;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.common.dao.BaseDao;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface StoreDao extends BaseDao<Store>{

    /**
     * 审核通过的商家分页
     * @param firstIndex
     * @param maxResults
     * @return
     */
    public List<Store> findStoresPage(Integer firstIndex, Integer maxResults);

    /**
     * 审核通过的商家记录数
     * @return
     */
    public Integer countStoresPage();


}
