package com.monkey.ele.merchant.service.impl;

import com.monkey.ele.common.pojo.Page;
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
    public Page<Order> findOrderByStoreId(String id, Integer page, Integer pageSize) {
        List<Order> orders = orderDao.findOrderByStoreId(id, page, pageSize);
        for(Order order : orders){
            User user = userService.loadUser(order.getUserId());
            order.setUser(user);
        }
        int itemTotal = this.getOrderCount(id);
        Page<Order> pageOrder = new Page<Order>(page, pageSize, orders, itemTotal);
        return pageOrder;
    }

    @Override
    public Page<Order> findOrderByStatus(String storeId, Integer status, Integer page, Integer pageSize) {
        List<Order> orders = orderDao.findOrderByStatus(storeId, status, page, pageSize);
        for(Order order : orders){
            User user = userService.loadUser(order.getUserId());
            order.setUser(user);
        }
        int itemTotal = this.getOrderByStatusCount(storeId,status);
        Page<Order> pageOrder = new Page<Order>(page, pageSize, orders, itemTotal);
        return pageOrder;
    }

    @Override
    public int getOrderByStatusCount(String storeId, Integer status) {
        return orderDao.getOrderByStatusCount(storeId, status);
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
