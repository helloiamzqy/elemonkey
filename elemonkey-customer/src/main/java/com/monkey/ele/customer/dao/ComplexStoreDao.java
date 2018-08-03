package com.monkey.ele.customer.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.customer.pojo.ComplexStore;
import com.monkey.ele.customer.pojo.Store;
import com.monkey.ele.customer.pojo.User;

import java.util.List;

public interface ComplexStoreDao extends BaseDao<ComplexStore> {

    List<ComplexStore> findPassStore();

    List<ComplexStore> findPassStorePage(Integer firstIndex, Integer maxResults);

    List<ComplexStore> findHotStore(int limit);

}
