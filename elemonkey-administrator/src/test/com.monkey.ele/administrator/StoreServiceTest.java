package com.monkey.ele.administrator;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.StoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class StoreServiceTest {

    private static ApplicationContext context;

    private static StoreService storeService;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Before
    public void start(){
        storeService  = context.getBean(StoreService.class);
    }

    @Test
    public void testFindAllStores() {
        Store store = new Store("啦啦啦2","china2","44sdss11",new Date(),new Date());
        storeService.addStore(store);

        List<Store> stores = storeService.findAllStore();
        Assert.assertTrue(stores.size()>0);
    }

    @Test
    public void testUpdateStatus() {
        Store store = new Store("啦啦啦4","china3","44sdss11",new Date(),new Date());
        Store newStore = storeService.addStore(store);

        int rs = storeService.updateCurrentAuditStatus(newStore.getId(),Store.StoreAuditStatus.DECLINE);
        Assert.assertTrue(rs > 0);
    }
}
