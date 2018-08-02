package com.monkey.ele.merchant.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.merchant.pojo.Product;

import java.util.List;

public interface ProductDao extends BaseDao<Product> {

    List<Product> findByStoreId(String storeId);
}
