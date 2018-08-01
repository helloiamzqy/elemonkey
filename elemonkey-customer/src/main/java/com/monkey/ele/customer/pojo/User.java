package com.monkey.ele.customer.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 2:44 PM
 **/
@Entity
@Table(name = "A_USER")
public class User {

    public static final class UserType {
        public static final Integer ADMINISTRATOR = 0X00;
        public static final Integer MERCHANT = 0x01;
        public static final Integer CUSTOMER = 0x02;
    }

    public static final class UserStatus {
        public static final Integer NORMAL = 0x00;
        public static final Integer FORBIDDEN = 0x01;
    }

    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String username;
    private String password;
    private Integer type;
    private Integer status = UserStatus.NORMAL;
    private Date createTime;
    private Date lastModifiedTime;

    @OneToOne
    @JoinColumn(name = "userId")
    private Identity identity;
    @OneToMany
    @JoinColumn(name = "userId")
    private Set<Contact> contacts;
    @OneToMany
    @JoinColumn(name = "userId")
    private Set<Order> orders;
    @OneToMany
    @JoinColumn(name = "userId")
    private Set<Complain> complains;

}
