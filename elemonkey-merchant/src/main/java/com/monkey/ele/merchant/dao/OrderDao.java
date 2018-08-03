package com.monkey.ele.merchant.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.merchant.pojo.Order;

import java.util.List;

public interface OrderDao extends BaseDao<Order> {

    List<Order> findOrderByStoreId(String storeId);

    List<Order> findOrderByStatus(Integer status);
}
