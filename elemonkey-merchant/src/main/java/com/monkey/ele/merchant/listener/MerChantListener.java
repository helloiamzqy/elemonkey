package com.monkey.ele.merchant.listener;

import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.util.JsonUtil;
import com.monkey.ele.merchant.pojo.Advertisement;
import com.monkey.ele.merchant.pojo.Complain;
import com.monkey.ele.merchant.pojo.Store;
import com.monkey.ele.merchant.service.AdvertisementService;
import com.monkey.ele.merchant.service.StoreService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class MerChantListener implements MessageListener {

    private static Logger LOGGER = Logger.getLogger(MerChantListener.class);

    @Autowired
    private StoreService storeService;

    @Autowired
    private AdvertisementService advertisementService;

    @Override
    public void onMessage(Message message) {
        TextMessage msg = (TextMessage) message;
        LOGGER.info(msg);
        try {
            JMail jMail = JsonUtil.json2pojo(msg.getText(), JMail.class);
            String type = jMail.getMessageType();
            Object object = jMail.getMessage();
            LOGGER.info("ACK_Type:" + type + " ,obj: " + object);
            switch (type){
                case JMail.JMailType.STORE_ACK :
                    Store store = JsonUtil.obj2pojo(object,Store.class);
                    storeService.modifyStore(store);
                    break;
                case JMail.JMailType.AD_ACK :
                    Advertisement advertisement = JsonUtil.obj2pojo(object,Advertisement.class);
                    advertisementService.updateAdvertisement(advertisement);
                    break;
                default:break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
