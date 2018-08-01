package com.monkey.ele.administrator.pojo;




import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "A_STOREINFORMATION")
public class StoreInformation implements Serializable {

    private static final long serialVersionUID = -3645630957086653497L;
    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String storeId;
    private String open;
    private String close;
    private Double deliveryArea;
    private String description;
    private Double deliveryCost;
    private String logoImage;

}
