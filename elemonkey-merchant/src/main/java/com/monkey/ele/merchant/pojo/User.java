package com.monkey.ele.merchant.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.aspectj.weaver.ast.Or;
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
 * @date 8/1/2018 2:44 PM
 **/
@Entity
@Table(name = "MC_USER")
public class User {

    public static final class UserType {
        public static final Integer ADMINISTRATOR = 0X00;
        public static final Integer MERCHANT = 0x01;
        public static final Integer CUSTOMER = 0x02;
    }

    public static final class UserStatus {
        public static final Integer NORMAL = 0x00;
        public static final Integer FORBIDDEN = 0x01;
    }

    @Id
    @GenericGenerator(strategy = "uuid", name = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String username;
    private String password;
    private Integer type;
    private Integer status = UserStatus.NORMAL;

    private String image;
    @Column(updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date lastModifiedTime;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "identityId")
    private Identity identity;
    @OneToMany
    @JoinColumn(name = "userId")
    private Set<Contact> contacts = new HashSet<Contact>();
    @OneToMany
    @JoinColumn(name = "userId")
    private Set<Order> orders = new HashSet<Order>();
    @OneToMany
    @JoinColumn(name = "userId")
    private Set<Complain> complains = new HashSet<Complain>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Complain> getComplains() {
        return complains;
    }

    public void setComplains(Set<Complain> complains) {
        this.complains = complains;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", image='" + image + '\'' +
                ", createTime=" + createTime +
                ", lastModifiedTime=" + lastModifiedTime +
                ", identity=" + identity +
                ", contacts=" + contacts +
                ", orders=" + orders +
                ", complains=" + complains +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
