package com.monkey.ele.administrator.dao.impl;

import com.monkey.ele.administrator.dao.StoreDao;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreDaoImpl extends AbstractBaseDao<Store> implements StoreDao {


    @Override
    public int updateCurrentAuditStatus(String id, Integer status) {
        String jpql = "update Store set currentAuditStatus = ?1 where id = ?2";
        return this.executeUpdate(jpql,status,id);
    }
}
