package com.monkey.ele.customer.service;

import com.monkey.ele.customer.pojo.Advertisement;

import java.util.List;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/3/2018 5:09 PM
 **/
public interface AdvertisementService {

    List<Advertisement> findAdvertisementsLimit(int limit);

}
