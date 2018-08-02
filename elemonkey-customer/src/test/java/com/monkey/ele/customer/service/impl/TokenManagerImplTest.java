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
        System.out.println(JWTUtils.sign(tml,TokenModel.TokenModelSetting.JWT_MAX_AGE));
    }

    @org.junit.Test
    public void parseJWT() {
        String jwtToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiO" +
                "jE1MzMxNzUzMDQwNTEsInBheWxvYWQiOiJ7XCJ1c2VySWRcIjpcInVzZX" +
                "JUb215XCIsXCJ0b2tlblwiOlwiMDA5YjgwMmI5YTBkNDBiNWJkYmZjOTk3ZjAwZDA" +
                "1MGNcIn0ifQ.XecMY6_UccQiECDtSFPWA3YBt6PN3YQEY3kYe2__8_U";
        TokenModel tml = JWTUtils.unsign(jwtToken);
        System.out.println(tml.getUserId());
        System.out.println(tml.getToken());
    }

    @org.junit.Test
    public void checkToken() {
    }

    @org.junit.Test
    public void parseToken() {
    }

    @org.junit.Test
    public void deleteToken() {
    }
}