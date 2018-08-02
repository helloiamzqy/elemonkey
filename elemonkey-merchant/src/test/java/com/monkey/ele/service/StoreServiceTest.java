package com.monkey.ele.service;

import com.monkey.ele.merchant.pojo.Store;
import com.monkey.ele.merchant.service.StoreService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 10:08 AM 8/2/2018
 */
public class StoreServiceTest {
    static ApplicationContext context = null;
    StoreService storeService;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Before
    public void before() {
        storeService = (StoreService) context.getBean("storeServiceImpl");
    }

    @Test
    public void addStore() throws Exception {
        Store store = new Store();
        store.setAddress("adsadaasas");
        storeService.applyStore(store);
    }
}
