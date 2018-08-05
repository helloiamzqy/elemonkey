package com.monkey.ele.administrator.service;

import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Complain;
import com.monkey.ele.common.pojo.Page;

import java.util.List;
import java.util.Map;

public interface ComplainService {

    public Complain addComplain(Complain complain);

    public Complain updateComplain(Complain complain);

    public List<Complain> findComplainsByStoreId(String storeId);

    public Page<Complain> findComplainsPageByStatus(int status, Integer pageIndex, Integer pageCount);

    public Map<String,Integer> countComplainStatus();
}
