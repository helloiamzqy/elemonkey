package com.monkey.ele.merchant.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.merchant.pojo.Order;

import java.util.List;

public interface OrderDao extends BaseDao<Order> {

    List<Order> findOrderByStoreId(String storeId);

    List<Order> findOrderByStatus(String storeId,Integer status);

    int getActiveOrderCount(String storeId);

    int getNewOrderCount(String storeId);

    int getOrderCount(String storeId);

    List<Order> findOrderByStoreId(String storeId,Integer page, Integer pageSize);

    List<Order> findOrderByStatus(String storeId, Integer status, Integer page, Integer pageSize);

    int getOrderByStatusCount(String storeId, Integer status);
}
