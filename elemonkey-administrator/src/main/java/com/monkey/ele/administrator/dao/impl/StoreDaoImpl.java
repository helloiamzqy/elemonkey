package com.monkey.ele.administrator.dao.impl;

import com.monkey.ele.administrator.dao.StoreDao;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.pojo.User;
import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreDaoImpl extends AbstractBaseDao<Store> implements StoreDao {

    @Override
    public int countStoresByStatus(Integer status) {
        String jpql = "select count(*) from Store where currentAuditStatus = ? and status = ?";
        return this.count(jpql,status,User.UserStatus.NORMAL);
    }

    @Override
    public List<Store> findStoresPageByStatus(Integer status,Integer firstIndex, Integer maxResults) {
        String jpql = "from Store where currentAuditStatus = ? and status = ? order by createTime desc";
        return this.findPage(firstIndex,maxResults,jpql,status,User.UserStatus.NORMAL);
    }

}
