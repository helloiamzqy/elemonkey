package com.monkey.ele.customer.service.impl;

import com.monkey.ele.common.util.JsonUtil;
import com.monkey.ele.customer.service.ComplexStoreService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StoreServiceImplTest {


    private static ApplicationContext context;


    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }



    @Test
    public void findPassStore() throws Exception {
        ComplexStoreService storeService = context.getBean(ComplexStoreService.class);
        String json = JsonUtil.obj2json(storeService.findPassStore());
        System.out.println(json);
    }
}