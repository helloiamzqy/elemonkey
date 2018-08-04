package com.monkey.ele.customer.service;

import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.customer.pojo.Product;

import java.util.List;

public interface ProductService {

    public Page<Product> getAllProductByStore(String storeId);

    public Page<Product> getAllProductByStorePage(String storeId,Integer firstIndex, Integer maxResults);
}
