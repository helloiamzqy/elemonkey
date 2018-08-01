package com.monkey.ele.merchant.pojo;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:44 PM
 **/
public class Order {

    public static final class OrderStatus {
        /**
         * 待接单
         */
        public static final Integer PENDING = 0x00;
        /**
         * 已接单
         */
        public static final Integer ACCEPT = 0x01;
        /**
         * 配送中
         */
        public static final Integer IN_DISTRIBUTION = 0x02;
        /**
         * 已完成
         */
        public static final Integer COMPLETE = 0x03;
        /**
         * 商家拒绝
         */
        public static final Integer DECLINE = 0x04;
        /**
         * 客户取消
         */
        public static final Integer CANCEL = 0x05;
    }

    private String id;
    private String userId;
    private String storeId;
    private Double deliveryCost;
    private Contact contact;
    private String remarks;
    private Integer status;
    private Comment comment;
    private Date createTime;

    @OneToMany
    private Set<OrderItem> orderItems;

}
