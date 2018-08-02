package com.monkey.ele.administrator.listener;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.StoreService;
import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
@Component(value = "storeListener")
public class AdminListener implements MessageListener {

    @Autowired
    private StoreService storeService;

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(((TextMessage)message).getText());
            try {
                JMail jMail = JsonUtil.json2pojo(((TextMessage) message).getText(), JMail.class);
                String type = jMail.getMessageType();
                switch (type){
                    case JMail.JMailType.STORE_REQUEST :
                        Store store = (Store) jMail.getMessage();
                        storeService.addStore(store);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
