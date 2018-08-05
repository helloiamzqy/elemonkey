package com.monkey.ele.administrator.dao;

import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Complain;
import com.monkey.ele.common.dao.BaseDao;

import java.util.List;

public interface ComplainDao extends BaseDao<Complain> {

    public List<Complain> findComplainsByStoreId(String storeId);

    public int countComplainsByStatus(Integer status);

    public List<Complain> findComplainsPageByStatus(Integer status, Integer firstIndex, Integer maxResults);

    public int countByStatus(Integer status);
}
