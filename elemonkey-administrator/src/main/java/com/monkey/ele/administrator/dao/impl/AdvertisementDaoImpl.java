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
    public List<Advertisement> findAdvertisements() {
        String jpql = "from Advertisement order by createTime desc,price desc";
        return this.findPage(1,5,jpql);
    }
}
