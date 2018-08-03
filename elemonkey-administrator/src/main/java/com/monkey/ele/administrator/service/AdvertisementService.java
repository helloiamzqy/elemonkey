package com.monkey.ele.administrator.service;

import com.monkey.ele.administrator.pojo.Advertisement;

import java.util.List;

public interface AdvertisementService {

    public Advertisement addAdvertisement(Advertisement advertisement);

    public Advertisement updateAdvertisement(Advertisement advertisement);

    public List<Advertisement> findAdvertisements(Integer status);
}
