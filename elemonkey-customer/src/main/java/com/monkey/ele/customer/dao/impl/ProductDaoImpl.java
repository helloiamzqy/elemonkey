package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.ProductDao;
import com.monkey.ele.customer.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductDaoImpl extends AbstractBaseDao<Product> implements ProductDao {


    @Override
    public List<Product> getAllProductByStore(String storeId) {
        String jpql = "From Product p where p.storeId = ?";
        return this.find(jpql,storeId);
    }

    @Override
    public List<Product> getAllProductByStorePage(String storeId, Integer firstIndex, Integer maxResults) {
        String jpql = "From Product p where p.storeId = ?";
        return this.findPage(firstIndex, maxResults,jpql,storeId);
    }

    @Override
    public Integer countProductByStore(String storeId) {
        return this.count("select count(*) from Product p where p.storeId = ?",storeId);
    }
}
