package com.monkey.ele.customer.service;

import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.customer.pojo.Store;

import java.util.List;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/3/2018 7:16 PM
 **/
public interface StoreService {

    List<Store> findHotStoreLimit(int limit);

    Page<Store> findPassStorePage(Integer firstIndex, Integer maxResults);

    Page<Store> findPassStore();

    Double watchStoreRank(String storeId);


}
