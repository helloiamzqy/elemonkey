package com.monkey.ele.administrator.listener;

import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Identity;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.pojo.User;
import com.monkey.ele.administrator.service.AdvertisementService;
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
    private UserService userService;


    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(((TextMessage)message).getText());
            try {
                JMail jMail = JsonUtil.json2pojo(((TextMessage) message).getText(), JMail.class);
                String type = jMail.getMessageType();
                switch (type){
                    case JMail.JMailType.STORE_REQUEST :
                        Object storeObject = jMail.getMessage();
                        Store store = JsonUtil.obj2pojo(storeObject,Store.class);
                        storeService.addStore(store);
                        break;
                    case JMail.JMailType.AD_REQUEST :
                        Object AdObject = jMail.getMessage();
                        Advertisement advertisement = JsonUtil.obj2pojo(AdObject,Advertisement.class);
                        advertisementService.addAdvertisement(advertisement);
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
