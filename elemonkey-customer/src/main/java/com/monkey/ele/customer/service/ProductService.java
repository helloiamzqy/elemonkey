package com.monkey.ele.customer.service;

import com.monkey.ele.customer.pojo.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProductByStore(String storeId);

    public List<Product> getAllProductByStorePage(String storeId,Integer firstIndex, Integer maxResults);
}
