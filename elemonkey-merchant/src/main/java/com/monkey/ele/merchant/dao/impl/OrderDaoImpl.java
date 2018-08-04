package com.monkey.ele.merchant.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.merchant.dao.OrderDao;
import com.monkey.ele.merchant.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl extends AbstractBaseDao<Order> implements OrderDao {

    public List<Order> findOrderByStoreId(String storeId){
        List<Order> orders = this.find("SELECT o FROM Order o WHERE o.storeId = ? order by o.createTime desc", storeId);
        return orders;
    }

    @Override
    public List<Order> findOrderByStatus(String storeId,Integer status) {
        List<Order> orders = this.find("SELECT o FROM Order o WHERE o.storeId = ? and o.status = ? order by o.createTime desc", storeId, status);
        return orders;
    }

    @Override
    public int getActiveOrderCount(String storeId) {
        return this.count("SELECT count(o) FROM Order o WHERE o.storeId = ? and o.status in (1,2)", storeId);
    }

    @Override
    public int getNewOrderCount(String storeId) {
        return this.count("SELECT count(o) FROM Order o WHERE o.storeId = ? and o.status = 0", storeId);
    }

    @Override
    public int getOrderCount(String storeId) {
        return this.count("SELECT count(o) FROM Order o WHERE o.storeId = ?", storeId);
    }

    @Override
    public List<Order> findOrderByStoreId(String storeId, Integer page, Integer pageSize) {
        return this.findPage((page -1) * pageSize, pageSize, "SELECT o FROM Order o WHERE o.storeId = ? order by o.createTime, o.id", storeId);
    }

    @Override
    public List<Order> findOrderByStatus(String storeId, Integer status, Integer page, Integer pageSize) {
        return this.findPage((page -1) * pageSize, pageSize, "SELECT o FROM Order o WHERE o.storeId = ? and o.status = ? order by o.createTime, o.id", storeId, status);
    }

    @Override
    public int getOrderByStatusCount(String storeId, Integer status) {
        return this.count("SELECT count(o) FROM Order o WHERE o.storeId = ? and o.status = ?", storeId, status);
    }
}
