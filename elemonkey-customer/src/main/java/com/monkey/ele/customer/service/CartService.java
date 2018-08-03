package com.monkey.ele.customer.service;

import com.monkey.ele.customer.pojo.Cart;

import java.util.List;

public interface CartService {

    public List<Cart> getCartByStore(String storeId,String sessionId);
}
