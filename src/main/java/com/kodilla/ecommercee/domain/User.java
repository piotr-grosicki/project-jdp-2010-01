package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    private Long id;
    private String userName;
    private String userKey;
    private String password;
    private boolean active;
    private Cart cart;
    private List<Order> orderList;

    public User(Long id, String userName, String userKey, String password, boolean active) {
        this.id = id;
        this.userName = userName;
        this.userKey = userKey;
        this.password = password;
        this.active = active;
    }

    public User(String userName, String userKey, String password, boolean active) {
        this.userName = userName;
        this.userKey = userKey;
        this.password = password;
        this.active = active;
    }

    public User() {
    }


    public User(String userName) {
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    @Column(name = "KEY")
    public String getUserKey() {
        return userKey;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "STATUS")
    public boolean isActive() {
        return active;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    @OneToMany(targetEntity = Order.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean status) {
        this.active = status;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
