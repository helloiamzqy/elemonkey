package com.monkey.ele.customer.pojo;

public class ComplexStore {

    private String storeid;
    private String open;
    private String close;
    private Double deliveryArea;
    private String description;
    private Double deliveryCost;
    private String logoImage;

    public ComplexStore(String storeid, String open, String close, Double deliveryArea, String description, Double deliveryCost, String logoImage) {
        this.storeid = storeid;
        this.open = open;
        this.close = close;
        this.deliveryArea = deliveryArea;
        this.description = description;
        this.deliveryCost = deliveryCost;
        this.logoImage = logoImage;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
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
