package com.monkey.ele.merchant.service;

import com.monkey.ele.merchant.pojo.Order;

import java.util.List;

public interface OrderService {

    Order updateOrder(Order order);

    List<Order> findOrderByStoreId(String storeId);
}
