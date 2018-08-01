package com.monkey.ele.merchant.pojo;

import java.util.Date;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:25 PM
 **/
public class Advertisement {

    public static final class AdvertisementStatus {
        public final static Integer PENDING = 0x00;
        public final static Integer ACCEPT = 0x01;
        public final static Integer DECLINE = 0x02;
    }

    private String id;
    private String storeId;
    private Double price;
    private String image;
    private Integer status = AdvertisementStatus.PENDING;
    private Date createTime;
    private Date confirmTime;
    private String confirmUserId;

}
