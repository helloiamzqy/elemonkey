package com.monkey.ele.merchant.service.impl;

import com.monkey.ele.common.jms.JmsSender;
import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.util.JsonUtil;
import com.monkey.ele.merchant.dao.AdvertisementDao;
import com.monkey.ele.merchant.pojo.Advertisement;
import com.monkey.ele.merchant.service.AdvertisementService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private static final Logger LOGGER = Logger.getLogger(AdvertisementServiceImpl.class);

    @Autowired
    private JmsSender jmsSender;

    @Autowired
    private AdvertisementDao advertisementDao;



    @Transactional
    @Override
    public void sendAdvertisement(Advertisement advertisement) {
        Advertisement ad = advertisementDao.add(advertisement);
        LOGGER.info("send Ad:" + ad);
        JMail jMail = new JMail(ad, JMail.JMailType.AD_REQUEST);
        try {
            jmsSender.sendTextMessage(JsonUtil.obj2json(jMail));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Transactional
    @Override
    public Advertisement updateAdvertisement(Advertisement advertisement) {
        return advertisementDao.update(advertisement);
    }
}
