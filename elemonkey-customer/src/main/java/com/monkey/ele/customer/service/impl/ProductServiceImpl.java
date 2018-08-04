package com.monkey.ele.customer.service.impl;

import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.customer.dao.ProductDao;
import com.monkey.ele.customer.pojo.Product;
import com.monkey.ele.customer.pojo.Store;
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
    public Page<Product> getAllProductByStore(String storeId) {
        Page<Product> productPage = new Page<>();
        int total = productDao.countProductByStore(storeId);
        productPage.setItemTotal(total);
        productPage.setPageIndex(0);
        productPage.setPageCount(total);
        productPage.setItems(productDao.getAllProductByStore(storeId));
        return productPage;
    }

    @Transactional
    @Override
    public Page<Product> getAllProductByStorePage(String storeId, Integer firstIndex, Integer maxResults) {
        Page<Product> productPage = new Page<>();
        int total = productDao.countProductByStore(storeId);
        productPage.setItemTotal(total);
        productPage.setPageIndex(0);
        productPage.setPageCount(total);
        productPage.setItems(productDao.getAllProductByStorePage(storeId, firstIndex, maxResults));
        return productPage;
    }
}
