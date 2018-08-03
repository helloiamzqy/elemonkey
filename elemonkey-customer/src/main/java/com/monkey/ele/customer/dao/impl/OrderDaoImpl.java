package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.OrderDao;
import com.monkey.ele.customer.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl extends AbstractBaseDao<Order> implements OrderDao {
    @Override
    public List<Order> findHistoryOrder(String uid) {
        List<Order> orders = this.find("SELECT o FROM Order o WHERE o.status in (3,4,5) and o.userId = ? order by o.createTime desc", uid);
        return orders;
    }

    @Override
    public List<Order> findActiveOrder(String uid) {
        List<Order> orders = this.find("SELECT o FROM Order o WHERE o.status in (0,1,2) and o.userId = ? order by o.createTime desc", uid);
        return orders;
    }
}
