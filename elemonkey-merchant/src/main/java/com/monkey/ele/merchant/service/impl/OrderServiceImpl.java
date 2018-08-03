package com.monkey.ele.merchant.service.impl;

import com.monkey.ele.merchant.dao.OrderDao;
import com.monkey.ele.merchant.pojo.Order;
import com.monkey.ele.merchant.service.OrderService;
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
    public Order updateOrder(Order order) {
        return orderDao.update(order);
    }

    @Override
    public List<Order> findOrderByStoreId(String storeId) {
        return orderDao.findOrderByStoreId(storeId);
    }

    @Override
    public List<Order> findOrderByStatus(Integer status) {
        return orderDao.findOrderByStatus(status);
    }
}
