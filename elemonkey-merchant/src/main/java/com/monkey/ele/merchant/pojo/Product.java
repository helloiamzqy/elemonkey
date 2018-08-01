package com.monkey.ele.merchant.pojo;


import ita.class1.group2.supermarket.common.dao.annotation.Table;

import java.io.Serializable;
import java.util.Date;

@Table("MC_PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = -8281539444668575519L;

    private String id;
    private String storeId;
    private String name;
    private String description;
    private String images;
    private Double price;
    private Integer quantity;
    private Date createTime;

}
