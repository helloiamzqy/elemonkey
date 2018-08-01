package com.monkey.ele.merchant.pojo;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.Set;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:03 PM
 **/
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

    private String id;
    private String name;
    private String address;
    private String license;
    private Integer status = User.UserStatus.NORMAL;
    private Integer currentAuditStatus = StoreAuditStatus.PENDING; // 当前审核状态，更新通过JMS（from A）
    private Date createTime;
    private Date lastModifiedTime;

    @OneToOne
    private StoreInformation storeInformation;
    @OneToMany
    private Set<Product> products;
    @OneToMany
    private Set<Order> orders;

}
