package com.monkey.ele.administrator.pojo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/1/2018 3:03 PM
 **/
@Entity
@Table(name = "A_STORE")
public class Store {

    public static final class StoreStatus {
        public static final Integer NORMAL = 0x00;
        public static final Integer FORBIDDEN = 0x01;
    }

    public static final class StoreAuditStatus {
        public final static Integer PENDING = 0x00;
        public final static Integer ACCEPT = 0x01;
        public final static Integer DECLINE = 0x02;
        public final static Integer REJECT = 0x03;
    }
    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String name;
    private String address;
    private String license;
    private Integer status = User.UserStatus.NORMAL;
    private Integer currentAuditStatus = StoreAuditStatus.PENDING; // 当前审核状态，更新通过JMS（from A）
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedTime;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "storeInfoId")
    private StoreInformation storeInformation;
    @OneToMany
    @JoinColumn(name = "storeId")
    private Set<Product> products = new HashSet<>();
    @OneToMany
    @JoinColumn(name = "storeId")
    private Set<Order> orders = new HashSet<>();

    public Store() {
    }

    public Store(String name, String address, String license, Date createTime, Date lastModifiedTime) {
        this.name = name;
        this.address = address;
        this.license = license;
        this.createTime = createTime;
        this.lastModifiedTime = lastModifiedTime;
    }

    public Store(String id,String name, String address, String license, Date createTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.license = license;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCurrentAuditStatus() {
        return currentAuditStatus;
    }

    public void setCurrentAuditStatus(Integer currentAuditStatus) {
        this.currentAuditStatus = currentAuditStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public StoreInformation getStoreInformation() {
        return storeInformation;
    }

    public void setStoreInformation(StoreInformation storeInformation) {
        this.storeInformation = storeInformation;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
