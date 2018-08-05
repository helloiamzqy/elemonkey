package com.monkey.ele.administrator.dao;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.common.dao.BaseDao;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface StoreDao extends BaseDao<Store>{

    public int countStoresByStatus(Integer status);

    public List<Store> findStoresPageByStatus(Integer status,Integer firstIndex, Integer maxResults);

    public int countByStatus(Integer status);


}
