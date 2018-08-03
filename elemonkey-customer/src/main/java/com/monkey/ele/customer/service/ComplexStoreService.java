package com.monkey.ele.customer.service;

import com.monkey.ele.customer.pojo.ComplexStore;
import com.monkey.ele.customer.pojo.Store;

import java.util.List;

public interface ComplexStoreService {

    public List<ComplexStore> findPassStore();

    public List<ComplexStore> findPassStorePage(Integer firstIndex, Integer maxResults);

}
