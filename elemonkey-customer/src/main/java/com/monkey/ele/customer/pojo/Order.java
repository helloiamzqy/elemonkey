package com.monkey.ele.customer.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:44 PM
 **/
@Entity
@Table(name = "A_ORDER")
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

    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String userId;
    private String storeId;
    private String address;
    private String phone;
    private Double deliveryCost;
    private String remarks;
    private Integer status;
    private Date createTime;

    @OneToMany
    @JoinColumn(name = "orderId")
    private Set<OrderItem> orderItems;
    @OneToOne
    @JoinColumn(name = "orderId")
    private Comment comment;

}
