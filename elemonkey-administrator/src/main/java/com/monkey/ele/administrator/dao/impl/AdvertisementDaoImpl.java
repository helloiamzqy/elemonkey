package com.monkey.ele.administrator.dao.impl;

import com.monkey.ele.administrator.dao.AdvertisementDao;
import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.pojo.User;
import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdvertisementDaoImpl extends AbstractBaseDao<Advertisement> implements AdvertisementDao {

    @Override
    public int countAdvertisementsByStatus(Integer status) {
        String jpql = "select count(*) from Advertisement where status = ?";
        return this.count(jpql,status);
    }

    @Override
    public List<Advertisement> findAdvertisementsPageByStatus(Integer status, Integer firstIndex, Integer maxResults) {
        String jpql = "from Advertisement where status = ? order by createTime desc, id desc";
        return this.findPage(firstIndex,maxResults,jpql,status);
    }

    @Override
    public int countByStatus(Integer status) {
        String jpql = "select count(*) from Advertisement where status = ?";
        return this.count(jpql,status);
    }
}
