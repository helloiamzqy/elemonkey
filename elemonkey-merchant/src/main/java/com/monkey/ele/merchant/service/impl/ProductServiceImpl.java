package com.monkey.ele.merchant.service.impl;

import com.monkey.ele.common.pojo.Page;
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

    @Override
    public List<Product> findByStoreId(String storeId) {
        return productDao.findByStoreId(storeId);
    }

    @Override
    public Page<Product> findByStoreId(String id, Integer pageNum, Integer pageSize) {
        List<Product> products = productDao.findByStoreId(id, pageNum, pageSize);
        int itemToal = this.getProductCountByStoreId(id);
        Page<Product> productPage = new Page<>(pageNum, pageSize, products, itemToal);
        return productPage;
    }

    @Override
    public int getProductCountByStoreId(String storeId) {
        return productDao.getProductCountByStoreId(storeId);
    }
}
