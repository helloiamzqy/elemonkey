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
import com.monkey.ele.common.jms.AckJmsSender;
import com.monkey.ele.common.jms.JmsSender;
import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private AckJmsSender ackJmsSender;


    @Transactional
    @Override
    public Store addStore(Store store) {
        StoreInformation storeInformation = store.getStoreInformation();
        User user = store.getUser();
        Identity identity = user.getIdentity();
        if(user!=null){
            if(userDao.load(user.getId())==null){
                userDao.add(user);
                if(identity!=null){
                    identityDao.add(user.getIdentity());
                }
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
                ackJmsSender.sendTextMessage(JsonUtil.obj2json(jMail));
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

    @Override
    public Map<String, Integer> countStoreStatus() {
        Map<String,Integer> map = new HashMap<>();
        map.put("0",storeDao.countByStatus(0));
        map.put("1",storeDao.countByStatus(1));
        map.put("2",storeDao.countByStatus(2));
        map.put("3",storeDao.countByStatus(3));
        return map;
    }


}
