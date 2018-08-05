package com.monkey.ele.merchant.service;

import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.merchant.pojo.Order;

import java.util.List;

public interface OrderService {

    Order updateOrder(Order order);

    List<Order> findOrderByStoreId(String storeId);

    int getActiveOrderCount(String storeId);

    int getNewOrderCount(String storeId);

    int getOrderCount(String storeId);

    List<Order> findOrderByStatus(String storeId, Integer status);

    Page<Order> findOrderByStoreId(String id, Integer page, Integer pageSize);

    Page<Order> findOrderByStatus(String storeId, Integer status, Integer page, Integer pageSize);

    int getOrderByStatusCount(String storeId, Integer status);

    Order addOrder(Order order);

    Order findOrderById(String orderId);
}
