package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.pojo.Cart;
import com.monkey.ele.customer.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class CartServiceImpl implements CartService {


    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List<Cart> getCartByStore(String storeId, String sessionId) {
        Map<String,Integer> cartMap = redisTemplate.opsForHash().entries(sessionId+"-"+sessionId);
        List<Cart> cartList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cartMap.entrySet()) {
            cartList.add(new Cart(entry.getKey(),entry.getValue()));
        }
        return cartList;
    }
}
