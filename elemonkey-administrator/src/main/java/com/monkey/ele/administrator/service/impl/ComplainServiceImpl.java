package com.monkey.ele.administrator.service.impl;

import com.monkey.ele.administrator.dao.ComplainDao;
import com.monkey.ele.administrator.dao.IdentityDao;
import com.monkey.ele.administrator.dao.UserDao;
import com.monkey.ele.administrator.pojo.Complain;
import com.monkey.ele.administrator.pojo.Identity;
import com.monkey.ele.administrator.pojo.User;
import com.monkey.ele.administrator.service.ComplainService;
import com.monkey.ele.common.pojo.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComplainServiceImpl implements ComplainService {

    static final Logger log = Logger.getLogger(ComplainServiceImpl.class);

    @Autowired
    private ComplainDao complainDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private IdentityDao identityDao;

    @Transactional
    @Override
    public Complain addComplain(Complain complain) {
        User user = complain.getUser();
        Identity identity = user.getIdentity();
        if(user !=null){
            if(userDao.load(user.getId()) == null){
                userDao.add(user);
                if(identity!=null){
                    identityDao.add(identity);
                }
            }
        }
        return complainDao.add(complain);
    }

    @Transactional
    @Override
    public Complain updateComplain(Complain complain) {
        return complainDao.update(complain);
    }

    @Override
    public List<Complain> findComplainsByStoreId(String storeId) {
        List<Complain> complains = complainDao.findComplainsByStoreId(storeId);
        List<String> userIds = new ArrayList<>();
        for (Complain complain :complains) {
            log.info(complain.getUserId());
            userIds.add(complain.getUserId());
        }
        log.info(userIds.size());
        List<User> users = userDao.findUsersByUserIds(userIds);
        Map<String,Complain> map = new HashMap<>();
        for (Complain complain :complains) {
            map.put(complain.getUserId(),complain);
        }
        for (User user : users) {
            user.setContacts(null);
            user.setIdentity(null);
            user.setOrders(null);
            user.setComplains(null);
            Complain complain = map.get(user.getId());
            if(complain!=null){
                complain.setUser(user);
            }
        }
        return complains;
    }

    @Override
    public Page<Complain> findComplainsPageByStatus(int status, Integer pageIndex, Integer pageCount) {
        List<Complain> complains = new ArrayList<>();
        int totalCount = complainDao.countComplainsByStatus(status);
        Page<Complain> page = new Page(pageIndex,pageCount,complains,totalCount);
        if(totalCount > 0){
            complains = complainDao.findComplainsPageByStatus(status,page.getFirstIndex(),pageCount);
            List<String> userIds = new ArrayList<>();
            for (Complain complain :complains) {
                log.info(complain.getUserId());
                userIds.add(complain.getUserId());
            }
            log.info(userIds.size());
            List<User> users = userDao.findUsersByUserIds(userIds);
            Map<String,Complain> map = new HashMap<>();
            for (Complain complain :complains) {
                map.put(complain.getUserId(),complain);
            }
            for (User user : users) {
                user.setContacts(null);
                user.setIdentity(null);
                user.setOrders(null);
                user.setComplains(null);
                Complain complain = map.get(user.getId());
                if(complain!=null){
                    complain.setUser(user);
                }
            }
        }
        page.setItems(complains);
        return page;
    }

    @Override
    public Map<String, Integer> countComplainStatus() {
        Map<String,Integer> map = new HashMap<>();
        map.put("0",complainDao.countByStatus(0));
        map.put("1",complainDao.countByStatus(1));
        map.put("2",complainDao.countByStatus(2));
        return map;
    }

}
