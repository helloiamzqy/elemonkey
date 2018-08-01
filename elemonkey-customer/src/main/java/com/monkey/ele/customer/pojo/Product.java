package com.monkey.ele.customer.pojo;




import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "MC_PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = -8281539444668575519L;

    private String id;
    private String storeId;
    private String name;
    private String description;
    private String images;
    private Double price;
    private Integer quantity;
    private Date createTime;

}
