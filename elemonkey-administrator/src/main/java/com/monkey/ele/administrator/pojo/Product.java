package com.monkey.ele.administrator.pojo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "A_PRODUCT")
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = -8281539444668575519L;
    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String storeId;
    private String name;
    private String description;
    private String images;
    private Double price;
    private Integer quantity;
    private Date createTime;

}
