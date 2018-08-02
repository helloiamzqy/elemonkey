package com.monkey.ele.administrator.service.impl;

import com.monkey.ele.administrator.dao.StoreDao;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.StoreService;
import com.monkey.ele.common.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    /**
     * 添加商店
     * @param store
     * @return
     */
    @Transactional
    @Override
    public Store addStore(Store store) {
        return storeDao.add(store);
    }


    /**
     * 更新审核状态
     * @param id
     * @param status
     * @return
     */
    @Transactional
    @Override
    public int updateCurrentAuditStatus(String id, Integer status) {
        return storeDao.updateCurrentAuditStatus(id,status);
    }

    @Override
    public Page<Store> findStoresPage(Page page) {
        page.setItemTotal(storeDao.countStoresPage());
        System.out.println(page.getFirstIndex());
        System.out.println(page.getPageCount());
        List<Store> stores = storeDao.findStoresByPage(page.getFirstIndex(),page.getPageCount());
        page.setItems(stores);
        return page;
    }


    @Transactional
    @Override
    public void delete(String id) {
        storeDao.delete(id);
    }

    @Override
    public List<Store> fingStoreList(Integer firstIndex, Integer maxResults) {
        return storeDao.findPage(firstIndex,maxResults);
    }

}
