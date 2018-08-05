package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.OrderDao;
import com.monkey.ele.customer.dao.StoreDao;
import com.monkey.ele.customer.pojo.Order;
import com.monkey.ele.customer.pojo.Store;
import com.monkey.ele.customer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StoreDao storeDao;

    @Transactional
    @Override
    public Order createOrder(Order order) {
        return orderDao.add(order);
    }

    @Transactional
    @Override
    public List<Order> findHistoryOrder(String uid) {
        List<Order> orders =  orderDao.findHistoryOrder(uid);
        for (Order order : orders){
            order.setStoreInfo(storeDao.load(order.getStoreId()));
        }
        return orders;
    }

    @Transactional
    @Override
    public List<Order> findActiveOrder(String uid) {
        List<Order> orders =  orderDao.findActiveOrder(uid);
        for (Order order : orders){
            order.setStoreInfo(storeDao.load(order.getStoreId()));
        }
        return orders;
    }
}
