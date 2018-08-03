package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.ComplainDao;
import com.monkey.ele.customer.pojo.Complain;
import com.monkey.ele.customer.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComplainServiceImpl implements ComplainService {

    @Autowired
    private ComplainDao complainDao;

    @Transactional
    @Override
    public Complain addComplain(Complain complain) {
        return complainDao.add(complain);
    }
}
