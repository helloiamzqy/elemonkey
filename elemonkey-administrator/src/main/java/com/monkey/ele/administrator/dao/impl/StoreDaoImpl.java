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
    public List<Store> findStoresPage(Integer firstIndex, Integer maxResults) {
        String jpql = "from Store where currentAuditStatus = ? and status = ?";
        return this.findPage(firstIndex,maxResults,jpql,Store.StoreAuditStatus.ACCEPT, User.UserStatus.NORMAL);
    }

    @Override
    public int countStoresPage() {
        String jpql = "select count(*) from Store where currentAuditStatus = ? and status =?";
        return this.count(jpql,Store.StoreAuditStatus.ACCEPT, User.UserStatus.NORMAL);
    }

}
