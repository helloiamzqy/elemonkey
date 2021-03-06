package com.monkey.ele.administrator.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:25 PM
 **/
@Entity
@Table(name = "A_ADVERTISEMENT")
public class Advertisement {

    public static final class AdvertisementStatus {
        public final static Integer PENDING = 0x00;
        public final static Integer ACCEPT = 0x01;
        public final static Integer DECLINE = 0x02;
    }

    @Id
    private String id;
    private String storeId;
    private Double price;
    private String image;
    private Integer status = AdvertisementStatus.PENDING;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @Column(updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date confirmTime;
    private String confirmUserId;

    public Advertisement() {
    }

    public Advertisement(String id,String storeId, Double price, String image) {
        this.id = id;
        this.storeId = storeId;
        this.price = price;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getConfirmUserId() {
        return confirmUserId;
    }

    public void setConfirmUserId(String confirmUserId) {
        this.confirmUserId = confirmUserId;
    }
}
