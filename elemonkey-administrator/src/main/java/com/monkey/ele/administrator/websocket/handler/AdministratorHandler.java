package com.monkey.ele.administrator.websocket.handler;

import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.util.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class AdministratorHandler extends TextWebSocketHandler {

    static final Logger log = Logger.getLogger(AdministratorHandler.class);

    private static final Map<String, WebSocketSession> ADMINS;

    private static final String ADMIN_ID = "admin_id";

    static {
        ADMINS = new HashMap<String, WebSocketSession>();
    }

    public AdministratorHandler() {
    }


    /**
     * js调用websocket.send时候，会调用该方法
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("收到:" + message.getPayload());
        WebSocketMessage msg = new TextMessage("server:" + message);
        try {
            session.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        log.info("websocket connection closed......");
        ADMINS.remove(session);
    }


    /**
     * 给某个用户发送消息
     * @param adminId
     * @param message
     */
    public boolean sendMessageToUser(String adminId, TextMessage message) {
        if (ADMINS.get(adminId) == null) {
            return false;
        }
        WebSocketSession session = ADMINS.get(adminId);
        log.info("sendMessage:" + session + "\ncontent:" + message.getPayload());
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

    /**
     * 给所有在线用户发送消息
     * @param message
     */
    public boolean sendMessageToUsers(TextMessage message) {
        boolean allSendSuccess = true;
        WebSocketSession session = null;
        for (String adminId : ADMINS.keySet()) {
            try {
                session = ADMINS.get(adminId);
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
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("connect to the websocket success......当前数量:" + ADMINS.size());
        String adminId = getAdminId(session);
        log.info("adminId:" + adminId);
        if (adminId != null) {
            ADMINS.put(adminId, session);
            session.sendMessage(new TextMessage(JsonUtil.obj2json(new JMail("webSocket 连接成功了","ws"))));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("websocket connection closed......");
        ADMINS.remove(session);
        log.info("剩余在线用户"+ADMINS.size());
    }

    private String getAdminId(WebSocketSession session) {
        try {
            String clientId = (String) session.getAttributes().get(ADMIN_ID);
            return clientId;
        } catch (Exception e) {
            return null;
        }
    }
}
