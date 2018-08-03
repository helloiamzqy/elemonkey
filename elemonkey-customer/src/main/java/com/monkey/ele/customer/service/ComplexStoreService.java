package com.monkey.ele.customer.service;

import com.monkey.ele.customer.pojo.ComplexStore;
import com.monkey.ele.customer.pojo.Store;

import java.util.List;

public interface ComplexStoreService {

    List<ComplexStore> findPassStore();

    List<ComplexStore> findPassStorePage(Integer firstIndex, Integer maxResults);

    Double watchStoreRank(String storeId);

    List<ComplexStore> findHotStore(int limit);

}
