package com.monkey.ele.merchant.service;

import com.monkey.ele.merchant.pojo.Store;
import com.monkey.ele.merchant.pojo.StoreInformation;

import java.util.Map;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 9:28 AM 8/2/2018
 */
public interface StoreService {

    public Store applyStore(Store store) throws Exception;

    public Store watchStore(String StoreId);

    public StoreInformation watchStoreInfo(String storeId);

    public Store modifyStore(Store store);

    public StoreInformation modifyStoreInfo(String storeId, StoreInformation storeInformation);

}
