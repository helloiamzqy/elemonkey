package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.OrderDao;
import com.monkey.ele.customer.pojo.Order;
import com.monkey.ele.customer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    @Override
    public Order createOrder(Order order) {
        return orderDao.add(order);
    }
}
