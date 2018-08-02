package com.monkey.ele.merchant.service;

import com.monkey.ele.merchant.pojo.Product;

import java.util.List;

public interface ProductService {

    Product loadProduct(String id);

    List<Product> findAllProducts();

    void deleteProduct(String id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);
}
