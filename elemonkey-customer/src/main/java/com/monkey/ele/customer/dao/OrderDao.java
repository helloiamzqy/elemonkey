package com.monkey.ele.customer.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.customer.pojo.Order;

import java.util.List;

public interface OrderDao extends BaseDao<Order> {

    List<Order> findHistoryOrder(String uid);

    List<Order> findActiveOrder(String uid);
}
