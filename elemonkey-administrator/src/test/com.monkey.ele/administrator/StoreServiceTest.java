package com.monkey.ele.administrator;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.StoreService;
import com.monkey.ele.common.pojo.Page;
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
//        Store store = new Store("啦啦啦2","china2","44sdss11",new Date(),new Date());
//        storeService.addStore(store);
//
//        List<Store> stores = storeService.findAllStore();
//        Assert.assertTrue(stores.size()>0);
    }

    @Test
    public void testUpdateStatus() {
        Store store = new Store("啦啦啦106","china3","44sdss11",new Date(),new Date());
        Store newStore = storeService.addStore(store);

        int rs = storeService.updateCurrentAuditStatus(newStore.getId(),Store.StoreAuditStatus.DECLINE);
        Assert.assertTrue(rs > 0);
    }


    @Test
    public void testDelete() {
        Store store = new Store("啦啦啦120","china3","44sdss11",new Date(),new Date());
        Store rs = storeService.addStore(store);
        storeService.delete(rs.getId());
    }


    @Test
    public void testCount() {
        Store store = new Store("啦啦啦120","china3","44sdss11",new Date(),new Date());
        Store rs = storeService.addStore(store);
        Assert.assertTrue(storeService.count()>0);
        //storeService.delete(rs.getId());
    }

    @Test
    public void findStoresPage() {
        Page<Store> page = new Page<Store>();
        page.setPageIndex(2);
        page.setPageCount(2);
        page = storeService.findStoresPage(page);
        System.out.println(page.getItemTotal());
        Assert.assertTrue(page.getItems().size() == 2);

    }


}
