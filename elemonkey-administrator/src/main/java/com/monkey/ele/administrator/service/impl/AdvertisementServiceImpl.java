package com.monkey.ele.administrator.service.impl;

import com.monkey.ele.administrator.dao.AdvertisementDao;
import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.AdvertisementService;
import com.monkey.ele.common.jms.JmsSender;
import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementDao advertisementDao;

    @Autowired
    private JmsSender jmsSender;

    @Transactional
    @Override
    public Advertisement addAdvertisement(Advertisement advertisement) {
        return advertisementDao.add(advertisement);
    }

    @Transactional
    @Override
    public Advertisement updateAdvertisement(Advertisement advertisement) {
        Advertisement rs = advertisementDao.update(advertisement);
        if(rs!=null){
            try {
                JMail jMail= new JMail(rs,JMail.JMailType.AD_ACK);
                jmsSender.sendTextMessage(JsonUtil.obj2json(jMail));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    @Override
    public Page<Advertisement> findAdvertisementsPageByStatus(int status, Integer pageIndex, Integer pageCount) {
        List<Advertisement> advertisements = new ArrayList<>();
        int totalCount = advertisementDao.countAdvertisementsByStatus(status);
        Page<Advertisement> page = new Page(pageIndex,pageCount,advertisements,totalCount);
        if(totalCount > 0){
            advertisements = advertisementDao.findAdvertisementsPageByStatus(status,page.getFirstIndex(),pageCount);
        }
        page.setItems(advertisements);
        return page;
    }


}
