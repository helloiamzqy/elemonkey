package com.monkey.ele.customer.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.customer.pojo.Product;

import java.util.List;

public interface ProductDao extends BaseDao<Product> {

    public List<Product> getAllProductByStore(String storeId);

    public List<Product> getAllProductByStorePage(String storeId,Integer firstIndex, Integer maxResults);

}
