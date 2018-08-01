package com.monkey.ele.customer.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 4:07 PM
 **/
@Entity
@Table(name = "A_ORDERITEM")
public class OrderItem {
    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String orderId;
    private String productId;
    private String productName;
    private Double productPrice;
    private String productCount;
    private String productImage;

}
