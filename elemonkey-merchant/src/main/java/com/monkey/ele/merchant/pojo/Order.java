package com.monkey.ele.merchant.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:44 PM
 **/
@Entity
@Table(name = "MC_ORDER")
public class Order {

    public static final class OrderStatus {
        /**
         * 待接单
         */
        public static final Integer PENDING = 0x00;
        /**
         * 已接单
         */
        public static final Integer ACCEPT = 0x01;
        /**
         * 配送中
         */
        public static final Integer IN_DISTRIBUTION = 0x02;
        /**
         * 已完成
         */
        public static final Integer COMPLETE = 0x03;
        /**
         * 商家拒绝
         */
        public static final Integer DECLINE = 0x04;
        /**
         * 客户取消
         */
        public static final Integer CANCEL = 0x05;
    }

    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String userId;
    private String storeId;
    private String address;
    private String phone;
    private Double deliveryCost;
    private String remarks;
    private Integer status;
    @Column(updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone="GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "orderId")
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();

    @OneToOne
    @JoinColumn(name="commentid",referencedColumnName="id")
    private Comment comment;
    @Transient
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", deliveryCost=" + deliveryCost +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", orderItems=" + orderItems +
                ", comment=" + comment +
                ", user=" + user +
                '}';
    }
}
