package com.monkey.ele.customer.service.impl;

import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.customer.pojo.Store;
import com.monkey.ele.customer.service.StoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StoreServiceImplTest {
    private static ApplicationContext context;

    private StoreService storeService;


    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Before
    public void start(){
        storeService = context.getBean(StoreService.class);
    }

    @Test
    public void findStoresPage() {
        Page<Store> page = new Page<Store>();
        page.setPageIndex(2);
        page.setPageCount(2);
        page = storeService.findStoresByPage(page);
        Assert.assertTrue(page.getItems().size() == 2);

    }
}
