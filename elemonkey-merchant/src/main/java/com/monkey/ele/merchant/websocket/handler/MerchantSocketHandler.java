package com.monkey.ele.merchant.websocket.handler;

import com.monkey.ele.common.pojo.Message;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 9:08 AM 8/3/2018
 */
@Service
public class MerchantSocketHandler extends TextWebSocketHandler {
    static final Logger LOG = Logger.getLogger(MerchantSocketHandler.class);
    /**
     * 维护M端socket会话
     */
    private static final Map<String, WebSocketSession> MERCHANTS;
    private static final String MERCHANT_ID = "merchant_id";

    static {
        MERCHANTS = new HashMap<String, WebSocketSession>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println();
        LOG.info(Message.WEBSOKCET_CONNECT_SUCCESS);
        String customerId = getCustomerId(session);
        LOG.info("merchantId:" + customerId);
        if (customerId != null) {
            MERCHANTS.put(customerId, session);
            session.sendMessage(new TextMessage("Hello,Monkey!"));
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        LOG.info("收到:" + message.getPayload());
        WebSocketMessage message1 = new TextMessage("server:" + message);
        try {
            session.sendMessage(message1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean sendMessageToUser(String merchantId, TextMessage message) {
        if (MERCHANTS.get(merchantId) == null) {
            return false;
        }
        WebSocketSession session = MERCHANTS.get(merchantId);
        LOG.info("sendMessage:" + session + "\ncontent:" + message.getPayload());
        if (!session.isOpen()) {
            return false;
        }
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean sendMessageToAllCustomer(TextMessage message) {
        boolean allSendSuccess = true;
        Set<String> customerIds = MERCHANTS.keySet();
        WebSocketSession session = null;
        for (String customerId : customerIds) {
            try {
                session = MERCHANTS.get(customerId);
                if (session.isOpen()) {
                    session.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                allSendSuccess = false;
            }
        }

        return allSendSuccess;
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        LOG.info("连接出错");
        MERCHANTS.remove(getCustomerId(session));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOG.info("连接已关闭：" + status);
        MERCHANTS.remove(getCustomerId(session));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    private String getCustomerId(WebSocketSession session) {
        try {
            String clientId = (String) session.getAttributes().get(MERCHANT_ID);
            return clientId;
        } catch (Exception e) {
            return null;
        }
    }
}
