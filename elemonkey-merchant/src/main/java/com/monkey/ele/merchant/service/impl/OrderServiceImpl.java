package com.monkey.ele.merchant.service.impl;

import com.monkey.ele.merchant.dao.OrderDao;
import com.monkey.ele.merchant.dao.UserDao;
import com.monkey.ele.merchant.pojo.Order;
import com.monkey.ele.merchant.pojo.User;
import com.monkey.ele.merchant.service.OrderService;
import com.monkey.ele.merchant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public Order updateOrder(Order order) {
        return orderDao.update(order);
    }

    @Override
    public List<Order> findOrderByStoreId(String storeId) {
        List<Order> orders = orderDao.findOrderByStoreId(storeId);
        for(Order order : orders){
            User user = userService.loadUser(order.getUserId());
            order.setUser(user);
        }
        return orders;
    }

    @Override
    public List<Order> findOrderByStatus(String storeId,Integer status) {
        List<Order> orders = orderDao.findOrderByStatus(storeId, status);
        for(Order order : orders){
            User user = userService.loadUser(order.getUserId());
            order.setUser(user);
        }
        return orders;
    }

    @Override
    public int getActiveOrderCount(String storeId) {
        return orderDao.getActiveOrderCount(storeId);
    }

    @Override
    public int getNewOrderCount(String storeId) {
        return orderDao.getNewOrderCount(storeId);
    }

    @Override
    public int getOrderCount(String storeId) {
        return orderDao.getOrderCount(storeId);
    }
}
