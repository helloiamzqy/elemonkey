package com.monkey.ele.administrator.dao.impl;

import com.monkey.ele.administrator.dao.ComplainDao;
import com.monkey.ele.administrator.pojo.Complain;
import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComplainDaoImpl extends AbstractBaseDao<Complain> implements ComplainDao {
    @Override
    public List<Complain> findComplainsByStoreId(String storeId) {
        String jpql = "from Complain where storeId = ? and status = ? order by createTime desc ,id desc";
        return this.find(jpql,storeId,Complain.ComplainStatus.ACCEPT);
    }

    @Override
    public int countComplainsByStatus(Integer status) {
        String jpql = "select count(*) from Complain where status = ?";
        return this.count(jpql,status);
    }

    @Override
    public List<Complain> findComplainsPageByStatus(Integer status, Integer firstIndex, Integer maxResults) {
        String jpql = "from Complain where status = ? order by createTime desc, id desc";
        return this.findPage(firstIndex,maxResults,jpql,status);
    }

    @Override
    public int countByStatus(Integer status) {
        String jpql = "select count(*) from Complain where status = ?";
        return this.count(jpql,status);
    }

}
