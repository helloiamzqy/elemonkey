package com.monkey.ele.administrator.dao;

import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.common.dao.BaseDao;

import java.util.List;

public interface AdvertisementDao extends BaseDao<Advertisement> {

    public int countAdvertisementsByStatus(Integer status);

    public List<Advertisement> findAdvertisementsPageByStatus(Integer status, Integer firstIndex, Integer maxResults);

    public int countByStatus(Integer status);


}
