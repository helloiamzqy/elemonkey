package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.ProductDao;
import com.monkey.ele.customer.pojo.Product;
import com.monkey.ele.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;


    @Transactional
    @Override
    public List<Product> getAllProductByStore(String storeId) {
        return productDao.getAllProductByStore(storeId);
    }

    @Transactional
    @Override
    public List<Product> getAllProductByStorePage(String storeId, Integer firstIndex, Integer maxResults) {
        return productDao.getAllProductByStorePage(storeId,firstIndex,maxResults);
    }
}
