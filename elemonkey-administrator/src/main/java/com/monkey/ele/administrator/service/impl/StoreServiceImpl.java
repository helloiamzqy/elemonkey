package com.monkey.ele.administrator.service.impl;

import com.monkey.ele.administrator.dao.IdentityDao;
import com.monkey.ele.administrator.dao.StoreDao;
import com.monkey.ele.administrator.dao.StoreInformationDao;
import com.monkey.ele.administrator.dao.UserDao;
import com.monkey.ele.administrator.pojo.Identity;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.pojo.StoreInformation;
import com.monkey.ele.administrator.pojo.User;
import com.monkey.ele.administrator.service.StoreService;
import com.monkey.ele.common.jms.JmsSender;
import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private IdentityDao identityDao;

    @Autowired
    private StoreInformationDao storeInformationDao;

    @Autowired
    private JmsSender jmsSender;


    @Transactional
    @Override
    public Store addStore(Store store) {
        StoreInformation storeInformation = store.getStoreInformation();
        User user = store.getUser();
        Identity identity = new Identity();
        if(user!=null){
            userDao.add(user);
            identity = user.getIdentity();
            if(identity!=null){
                identityDao.add(user.getIdentity());
            }
        }
        if(storeInformation!=null){
            storeInformationDao.add(storeInformation);
        }
        return storeDao.add(store);
    }


    @Transactional
    @Override
    public Store updateStatus(Store store) {
        Store rs = storeDao.update(store);
        if(rs!=null){
            try {
                JMail jMail= new JMail(rs,JMail.JMailType.STORE_ACK);
                jmsSender.sendTextMessage(JsonUtil.obj2json(jMail));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }



    @Override
    public Page<Store> findStoresPageByStatus(int status,Integer pageIndex,Integer pageCount) {
        List<Store> stores = new ArrayList<>();
        int totalCount = storeDao.countStoresByStatus(status);
        Page<Store> page = new Page(pageIndex,pageCount,stores,totalCount);
        if(totalCount > 0){
            stores = storeDao.findStoresPageByStatus(status,page.getFirstIndex(),pageCount);
        }
        page.setItems(stores);
        return page;
    }


}
