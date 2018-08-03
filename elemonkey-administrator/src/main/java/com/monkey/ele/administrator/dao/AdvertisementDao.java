package com.monkey.ele.administrator.dao;

import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.common.dao.BaseDao;

import java.util.List;

public interface AdvertisementDao extends BaseDao<Advertisement> {

    public List<Advertisement> findAdvertisements();
}
