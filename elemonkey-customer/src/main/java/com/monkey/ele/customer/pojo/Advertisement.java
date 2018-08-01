package com.monkey.ele.customer.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:25 PM
 **/
@Entity
@Table(name = "A_ADVERTISEMENT")
public class Advertisement {

    public static final class AdvertisementStatus {
        public final static Integer PENDING = 0x00;
        public final static Integer ACCEPT = 0x01;
        public final static Integer DECLINE = 0x02;
    }

    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String storeId;
    private Double price;
    private String image;
    private Integer status = AdvertisementStatus.PENDING;
    private Date createTime;
    private Date confirmTime;
    private String confirmUserId;

}
