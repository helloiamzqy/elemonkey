package com.monkey.ele.customer.service;

import com.monkey.ele.customer.pojo.Cart;

import java.util.List;

public interface CartService {

    public List<Cart> getCartByStore(String sessionId,String storeId);

    public void addCart(String sessionId,String storeId,Cart cart);

    public boolean reduceCart(String sessionId,String storeId,Cart cart);

    public boolean emptyCart(String sessionId,String storeId);
}
