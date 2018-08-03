package com.monkey.ele.merchant.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.merchant.dao.OrderDao;
import com.monkey.ele.merchant.pojo.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl extends AbstractBaseDao<Order> implements OrderDao {

    public List<Order> findOrderByStoreId(String storeId){
        List<Order> orders = this.find("SELECT o FROM Order o WHERE o.storeId = ?", storeId);
        return orders;
    }

    @Override
    public List<Order> findOrderByStatus(Integer status) {
        List<Order> orders = this.find("SELECT o FROM Order o WHERE o.status = ? order by o.createTime desc", status);
        return orders;
    }
}
