package com.monkey.ele.merchant.websocket.interceptor;

import com.monkey.ele.merchant.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;
import java.security.Security;
import java.util.Map;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 10:05 AM 8/3/2018
 */
public class WebSocketInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        String userId = (String) SecurityUtils.getSubject().getPrincipal();
        if(userId != null){
            map.put("merchant_id", userId);
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
