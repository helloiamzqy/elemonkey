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
    private String id;
    private String open;
    private String close;
    private Double deliveryArea;
    private String description;
    private Double deliveryCost;
    private String logoImage;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public Double getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(Double deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }
}
