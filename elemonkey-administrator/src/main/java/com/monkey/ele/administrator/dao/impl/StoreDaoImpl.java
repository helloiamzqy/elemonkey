package com.monkey.ele.administrator.dao.impl;

import com.monkey.ele.administrator.dao.StoreDao;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreDaoImpl extends AbstractBaseDao<Store> implements StoreDao {

    /**
     * 更新商家审核状态
     * @param id
     * @param status
     * @return
     */
    @Override
    public int updateCurrentAuditStatus(String id, Integer status) {
        String jpql = "update Store set currentAuditStatus =? where id =?";
        return this.executeUpdate(jpql,status,id);
    }

    @Override
    public List<Store> findStoresByPage(Integer firstIndex, Integer maxResults) {
        String jpql = "select new Store(s.id, s.name, s.address, s.license, s.createTime) from Store s";
        return this.findPage(firstIndex,maxResults,jpql);
    }

}
