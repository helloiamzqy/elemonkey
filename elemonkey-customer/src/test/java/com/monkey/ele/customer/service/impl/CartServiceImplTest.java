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

    @Test
    public void addCart() {
        CartService cartService= context.getBean(CartService.class);
        Cart cart = new Cart("ccasdsad",0);
        cartService.addCart("aaaa","bbbb",cart);
        List<Cart> cartList= cartService.getCartByStore("aaaa","bbbb");
        System.out.println(cartList.size());
    }

    @Test
    public void emptyCart() {
        CartService cartService= context.getBean(CartService.class);
        cartService.emptyCart("aaaa","bbbb");
    }

    @Test
    public void reduceCart() {
        CartService cartService= context.getBean(CartService.class);
        Cart cart = new Cart("ccasdsad",0);
        cartService.reduceCart("aaaa","bbbb",cart);
        List<Cart> cartList= cartService.getCartByStore("aaaa","bbbb");
        System.out.println(cartList.size());
    }
}