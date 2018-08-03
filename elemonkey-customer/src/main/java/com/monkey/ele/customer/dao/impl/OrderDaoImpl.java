package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.OrderDao;
import com.monkey.ele.customer.pojo.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractBaseDao<Order> implements OrderDao {
}
