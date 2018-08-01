package com.monkey.ele.customer.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "A_IDENTITY")
public class Identity {
    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String userId;
    private String name;
    private String idCardNumber;
    private String idCardPic;
    private Date createTime;
    private Date lastModifiedTime;

}
