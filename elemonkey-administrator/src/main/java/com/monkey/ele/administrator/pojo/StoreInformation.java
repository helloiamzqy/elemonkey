package com.monkey.ele.administrator.pojo;




import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "A_STOREINFORMATION")
public class StoreInformation implements Serializable {

    private static final long serialVersionUID = -3645630957086653497L;

    private String id;
    private String storeId;
    private String open;
    private String close;
    private Double deliveryArea;
    private String description;
    private Double deliveryCost;
    private String logoImage;

}
