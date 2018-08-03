package com.monkey.ele.customer.service;

import com.monkey.ele.customer.pojo.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    List<Order> findHistoryOrder(String uid);

    List<Order> findActiveOrder(String uid);
}
