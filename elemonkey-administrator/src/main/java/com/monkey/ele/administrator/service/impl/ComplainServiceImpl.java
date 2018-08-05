package com.monkey.ele.administrator.service.impl;

import com.monkey.ele.administrator.dao.ComplainDao;
import com.monkey.ele.administrator.pojo.Complain;
import com.monkey.ele.administrator.service.ComplainService;
import com.monkey.ele.common.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComplainServiceImpl implements ComplainService {

    @Autowired
    private ComplainDao complainDao;

    @Transactional
    @Override
    public Complain addComplain(Complain complain) {
        return complainDao.add(complain);
    }

    @Transactional
    @Override
    public Complain updateComplain(Complain complain) {
        return complainDao.update(complain);
    }

    @Override
    public List<Complain> findComplainsByStoreId(String storeId) {
        return complainDao.findComplainsByStoreId(storeId);
    }

    @Override
    public Page<Complain> findComplainsPageByStatus(int status, Integer pageIndex, Integer pageCount) {
        List<Complain> complains = new ArrayList<>();
        int totalCount = complainDao.countComplainsByStatus(status);
        Page<Complain> page = new Page(pageIndex,pageCount,complains,totalCount);
        if(totalCount > 0){
            complains = complainDao.findComplainsPageByStatus(status,page.getFirstIndex(),pageCount);
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
