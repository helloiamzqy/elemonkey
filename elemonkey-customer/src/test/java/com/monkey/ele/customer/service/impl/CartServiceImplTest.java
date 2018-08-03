package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.pojo.Cart;
import com.monkey.ele.customer.service.CartService;
import com.monkey.ele.customer.service.ContectService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class CartServiceImplTest {


    private static ApplicationContext context;


    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }



    @Test
    public void getCartByStore() {
        CartService cartService= context.getBean(CartService.class);
        List<Cart> cartList= cartService.getCartByStore("aa","aa");

    }
}