package com.monkey.ele.merchant.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:03 PM
 **/
@Entity
@Table(name = "A_STORE")
public class Store {

    public static final class StoreStatus {
        public static final Integer NORMAL = 0x00;
        public static final Integer FORBIDDEN = 0x01;
    }

    public static final class StoreAuditStatus {
        public final static Integer PENDING = 0x00;
        public final static Integer ACCEPT = 0x01;
        public final static Integer DECLINE = 0x02;
        public final static Integer REJECT = 0x03;
    }
    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String name;
    private String address;
    private String license;
    private Integer status = User.UserStatus.NORMAL;
    private Integer currentAuditStatus = StoreAuditStatus.PENDING; // 当前审核状态，更新通过JMS（from A）
    private Date createTime;
    private Date lastModifiedTime;

    @OneToOne
    @JoinColumn(name = "storeId")
    private StoreInformation storeInformation;
    @OneToMany
    @JoinColumn(name = "storeId")
    private Set<Product> products;
    @OneToMany
    @JoinColumn(name = "storeId")
    private Set<Order> orders;

}
