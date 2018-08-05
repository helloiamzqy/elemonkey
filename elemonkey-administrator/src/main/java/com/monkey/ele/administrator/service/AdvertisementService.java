package com.monkey.ele.administrator.service;

import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.common.pojo.Page;

import java.util.List;
import java.util.Map;

public interface AdvertisementService {

    public Advertisement addAdvertisement(Advertisement advertisement);

    public Advertisement updateAdvertisement(Advertisement advertisement);

    public Page<Advertisement> findAdvertisementsPageByStatus(int status, Integer pageIndex, Integer pageCount);

    public Map<String,Integer> countAdStatus();
}
