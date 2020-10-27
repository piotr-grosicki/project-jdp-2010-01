package com.kodilla.ecommercee.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USER")
public class User {

    private Long id;
    private String userName;
    private String userKey;
    private String password;
    private boolean status;
    private Cart cart;

    public User(Long id, String userName, String userKey, String password, boolean status) {
        this.id = id;
        this.userName = userName;
        this.userKey = userKey;
        this.password = password;
        this.status = status;
    }

    public User() {
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
    public boolean isStatus() {
        return status;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART")
    public Cart getCart() {
        return cart;
    }

    private void setId(Long id) {
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

    public void setStatus(boolean status) {
        this.status = status;
    }

    private void setCart(Cart cart) {
        this.cart = cart;
    }


}
