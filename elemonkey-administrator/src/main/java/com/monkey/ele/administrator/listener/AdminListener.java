package com.monkey.ele.administrator.listener;

import com.monkey.ele.administrator.pojo.*;
import com.monkey.ele.administrator.service.AdvertisementService;
import com.monkey.ele.administrator.service.ComplainService;
import com.monkey.ele.administrator.service.StoreService;
import com.monkey.ele.administrator.service.UserService;
import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
@Component(value = "monkeyListener")
public class AdminListener implements MessageListener {

    @Autowired
    private StoreService storeService;

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private ComplainService complainService;


    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(((TextMessage)message).getText());
            try {
                JMail jMail = JsonUtil.json2pojo(((TextMessage) message).getText(), JMail.class);
                String type = jMail.getMessageType();
                Object object = jMail.getMessage();
                switch (type){
                    case JMail.JMailType.STORE_REQUEST :
                        Store store = JsonUtil.obj2pojo(object,Store.class);
                        storeService.addStore(store);
                        break;
                    case JMail.JMailType.AD_REQUEST :
                        Advertisement advertisement = JsonUtil.obj2pojo(object,Advertisement.class);
                        advertisementService.addAdvertisement(advertisement);
                        break;
                    case JMail.JMailType.COMPLAIN_REQUEST:
                        Complain complain = JsonUtil.obj2pojo(object,Complain.class);
                        complainService.addComplain(complain);
                        break;
                        default:break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
