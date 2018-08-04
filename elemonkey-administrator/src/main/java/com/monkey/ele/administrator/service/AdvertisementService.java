package com.monkey.ele.administrator.service;

import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.common.pojo.Page;

import java.util.List;

public interface AdvertisementService {

    public Advertisement addAdvertisement(Advertisement advertisement);

    public Advertisement updateAdvertisement(Advertisement advertisement);

    public Page<Advertisement> findAdvertisementsPageByStatus(int status, Integer pageIndex, Integer pageCount);
}
