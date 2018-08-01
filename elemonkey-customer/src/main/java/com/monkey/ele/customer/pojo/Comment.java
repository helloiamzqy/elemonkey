package com.monkey.ele.customer.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 4:25 PM
 **/
@Entity
@Table(name = "A_COMMENT")
public class Comment {
    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String userId;
    private String orderId;
    private Integer rank;
    private String message;

}
