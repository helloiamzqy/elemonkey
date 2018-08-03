package com.monkey.ele.administrator.dao.impl;

import com.monkey.ele.administrator.dao.AdvertisementDao;
import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdvertisementDaoImpl extends AbstractBaseDao<Advertisement> implements AdvertisementDao {

    @Override
    public List<Advertisement> findAdvertisements(Integer status) {
        String jpql ="from Advertisement where status = ?";
        return this.find(jpql,status);
    }
}
