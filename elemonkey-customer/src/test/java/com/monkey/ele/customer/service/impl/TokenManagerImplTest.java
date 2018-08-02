package com.monkey.ele.customer.service.impl;

import com.monkey.ele.common.pojo.TokenModel;
import com.monkey.ele.common.util.JWTUtils;
import com.monkey.ele.customer.service.TokenManager;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class TokenManagerImplTest {


    private static ApplicationContext context;


    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }



    @org.junit.Test
    public void createToken() {
        TokenManager tm = context.getBean(TokenManager.class);
        TokenModel tml= tm.createToken("userTomy");
        System.out.println(JWTUtils.sign(tml,1));
    }


    @org.junit.Test
    public void checkToken() {
        TokenManager tm = context.getBean(TokenManager.class);
        TokenModel tml = new TokenModel();
        tml.setToken("12323weewqe");
        tml.setUserId("12348919564");
        tm.checkToken(tml);

    }


    @org.junit.Test
    public void parseToken() {
        String jwtToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwY" +
                "Xlsb2FkIjoie1widXNlcklkXCI6XCJ1c2VyVG9teVwiLFw" +
                "idG9rZW5cIjpcIjgzNmU0ODg1YTM5MzRlZmQ5YTUyY2ZhYmJi" +
                "ZDA1NmQ5XCJ9In0.TZ4X7K2G0ZyJU7Uoly8TABg89PeXBqoAWI" +
                "HVpP4iUPQ";
        TokenModel tml = JWTUtils.unsign(jwtToken);
        Assert.assertTrue(tml!=null);
    }

    @org.junit.Test
    public void deleteToken() {

    }
}