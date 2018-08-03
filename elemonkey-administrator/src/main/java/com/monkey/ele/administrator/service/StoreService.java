package com.monkey.ele.administrator.service;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.common.pojo.Page;

import java.util.List;

public interface StoreService {

    /**
     * 添加商店
     * @param store
     * @return
     */
    public Store addStore(Store store);

    /**
     * 更新审核状态
     * @param store
     * @return
     */
    public Store updateStatus(Store store);

    /**
     * 分页
     * @param page
     * @return
     */
    public Page<Store> findStoresPage(Page page);


    /**
     * 根据不同状态获取商店的集合
     * @param status
     * @return
     */
    public List<Store> findStores(int status);




}
