package com.monkey.ele.merchant.service.impl;

import com.monkey.ele.merchant.dao.ProductDao;
import com.monkey.ele.merchant.pojo.Product;
import com.monkey.ele.merchant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product loadProduct(String id) {
        return productDao.load(id);
    }


    @Override
    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    @Transactional
    @Override
    public void deleteProduct(String id) {
        productDao.delete(id);
    }

    @Transactional
    @Override
    public Product saveProduct(Product product) {
        return productDao.add(product);
    }

    @Transactional
    @Override
    public Product updateProduct(Product product) {
        return productDao.update(product);
    }
}
