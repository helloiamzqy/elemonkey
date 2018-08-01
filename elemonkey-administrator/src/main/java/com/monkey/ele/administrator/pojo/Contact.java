package com.monkey.ele.administrator.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:53 PM
 **/
@Entity
@Table(name = "A_CONTACT")
public class Contact {
    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String userId;
    private String address;
    private String phone;
    private Date createTime;

}
