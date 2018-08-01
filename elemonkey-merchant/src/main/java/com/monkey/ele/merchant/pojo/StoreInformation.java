package com.monkey.ele.merchant.pojo;


import ita.class1.group2.supermarket.common.dao.annotation.Table;

import java.io.Serializable;

@Table("MC_STOREINFORMATION")
public class StoreInformation implements Serializable {

    private static final long serialVersionUID = -3645630957086653497L;

    private String id;
    private String storeId;
    private String open;
    private String close;
    private Double deliveryArea;
    private String description;
    private Double deliveryCost;
    private String logoImage;

}
