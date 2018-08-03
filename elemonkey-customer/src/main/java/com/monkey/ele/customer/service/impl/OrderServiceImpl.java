package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.OrderDao;
import com.monkey.ele.customer.pojo.Order;
import com.monkey.ele.customer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    @Override
    public Order createOrder(Order order) {
        return orderDao.add(order);
    }

    @Override
    public List<Order> findHistoryOrder(String uid) {
        return orderDao.findHistoryOrder(uid);
    }

    @Override
    public List<Order> findActiveOrder(String uid) {
        return orderDao.findActiveOrder(uid);
    }
}
