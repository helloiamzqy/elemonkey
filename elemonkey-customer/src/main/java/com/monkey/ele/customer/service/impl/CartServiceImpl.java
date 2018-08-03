package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.pojo.Cart;
import com.monkey.ele.customer.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service
public class CartServiceImpl implements CartService {


    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List<Cart> getCartByStore(String sessionId,String storeId) {
        Map<String,String> cartMap = redisTemplate.opsForHash().entries(sessionId+"-"+storeId);
        List<Cart> cartList = new ArrayList<>();
        for (Map.Entry<String, String> entry : cartMap.entrySet()) {
            cartList.add(new Cart(entry.getKey(),Integer.parseInt(entry.getValue())));
        }
        return cartList;
    }

    @Override
    public void addCart(String sessionId,String storeId,Cart cart) {
        redisTemplate.boundHashOps(sessionId+"-"+storeId).increment(cart.getProductId(),1);
        redisTemplate.expire(sessionId+"-"+storeId,Cart.CartSetting.Cart_EXPIRES_TIME,TimeUnit.MINUTES);
    }

    @Override
    public boolean reduceCart(String sessionId, String storeId, Cart cart) {
        String numStr = (String) redisTemplate.boundHashOps(sessionId+"-"+storeId).get(cart.getProductId());
        if(numStr!=null){
            int productNum = Integer.parseInt(numStr);
            if(productNum==1){
                redisTemplate.boundHashOps(sessionId+"-"+storeId).delete(cart.getProductId());
            }
            else {
                productNum -=1;
                redisTemplate.boundHashOps(sessionId+"-"+storeId).put(cart.getProductId(),String.valueOf(productNum));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean emptyCart(String sessionId, String storeId) {
        redisTemplate.delete(sessionId+"-"+storeId);
        return true;
    }
}
