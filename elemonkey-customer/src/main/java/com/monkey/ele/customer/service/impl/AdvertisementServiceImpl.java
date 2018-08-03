package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.AdvertisementDao;
import com.monkey.ele.customer.pojo.Advertisement;
import com.monkey.ele.customer.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/3/2018 5:12 PM
 **/
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired private AdvertisementDao advertisementDao;

    @Override
    public List<Advertisement> findAdvertisementsLimit(int limit) {
        return advertisementDao.findPage(0, limit, "select ad from Advertisement ad where ad.status = ? order by ad.confirmTime desc", Advertisement.AdvertisementStatus.ACCEPT);
    }

}
