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
        String jpql = "from Store where currentAuditStatus = ? order by createTime desc";
        return this.findPage(firstIndex,maxResults,jpql,1);
    }

    @Override
    public Integer countStoresPage() {
        String jpql = "select count(*) from Store where currentAuditStatus = ?";
        return this.count(jpql,1);
    }

}
