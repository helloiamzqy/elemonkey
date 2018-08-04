package com.monkey.ele.administrator.service;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.common.pojo.Page;

import java.util.List;

public interface StoreService {


    public Store addStore(Store store);

    public Store updateStatus(Store store);

    public Page<Store> findStoresPageByStatus(int status,Integer pageIndex,Integer pageCount);




}
