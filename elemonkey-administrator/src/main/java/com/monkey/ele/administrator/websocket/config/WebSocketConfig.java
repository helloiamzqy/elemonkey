package com.monkey.ele.administrator.websocket.config;

import com.monkey.ele.administrator.websocket.handler.AdministratorHandler;
import com.monkey.ele.administrator.websocket.interceptor.WebSocketInterceptor;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@EnableWebSocket
@EnableWebMvc
public class WebSocketConfig implements WebSocketConfigurer {

    static final Logger log = Logger.getLogger(WebSocketConfig.class);

    public WebSocketConfig() {
        System.out.println("websocket。。。。。。。。。。。。。。。。");
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(adminSocketHandler(), "/pushSocket").setAllowedOrigins("*")
                .addInterceptors(webSocketInterceptor());

    }

    @Bean
    public WebSocketHandler adminSocketHandler() {
        return new AdministratorHandler();
    }

    @Bean
    public WebSocketInterceptor webSocketInterceptor() {
        return new WebSocketInterceptor();
    }

}
