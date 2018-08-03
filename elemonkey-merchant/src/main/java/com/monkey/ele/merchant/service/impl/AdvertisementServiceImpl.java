package com.monkey.ele.merchant.service.impl;

import com.monkey.ele.common.jms.JmsSender;
import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.util.JsonUtil;
import com.monkey.ele.merchant.pojo.Advertisement;
import com.monkey.ele.merchant.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private JmsSender jmsSender;

    @Override
    public void sendAdvertisement(Advertisement advertisement) {
        JMail jMail = new JMail(advertisement, JMail.JMailType.AD_REQUEST);
        try {
            jmsSender.sendTextMessage(JsonUtil.obj2json(jMail));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}