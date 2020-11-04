package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "ORDERS")
public class Order {

    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private Cart cart;

    public Order(Long id, LocalDate orderDate, Cart cart) {
        this.id = id;
        this.orderDate = orderDate;
        this.cart = cart;
    }

    public Order() {
    }

    public Order(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {

        return id;
    }

    @Column(name = "ORDER_DATE")
    public LocalDate getOrderDate() {
        return orderDate;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {

        return cart;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setCart(Cart cart) {

        this.cart = cart;
    }

    public void setId(Long id) {

        this.id = id;
    }
}
