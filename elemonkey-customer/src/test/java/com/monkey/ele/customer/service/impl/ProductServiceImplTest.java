package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.pojo.Product;
import com.monkey.ele.customer.service.ProductService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceImplTest {


    private static ApplicationContext context;


    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }



    @Test
    public void getAllProductByStore() {
        ProductService productService = context.getBean(ProductService.class);
//        List<Product> list = productService.getAllProductByStore("4028b88164fab2b60164fab446160000");
//        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void getAllProductByStorePage() {
        ProductService productService = context.getBean(ProductService.class);
//        List<Product> list = productService.getAllProductByStorePage("4028b88164fab2b60164fab446160000",0,2);
//        Assert.assertTrue(list.size()==2);
    }
}