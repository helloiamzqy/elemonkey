package com.monkey.ele.merchant.websocket;

import com.monkey.ele.merchant.websocket.handler.MerchantSocketHandler;
import com.monkey.ele.merchant.websocket.interceptor.WebSocketInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 9:01 AM 8/3/2018
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(merchantSocketHandler(), "/merchant/order")
                .addInterceptors(new WebSocketInterceptor())
                .setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler merchantSocketHandler() {
        return new MerchantSocketHandler();
    }

}
