package com.monkey.ele.merchant.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.merchant.dao.ProductDao;
import com.monkey.ele.merchant.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl extends AbstractBaseDao<Product> implements ProductDao {

    @Override
    public List<Product> findByStoreId(String storeId) {
        return this.find("SELECT p FROM Product p WHERE p.storeId = ? order by p.createTime", storeId);
    }
}
