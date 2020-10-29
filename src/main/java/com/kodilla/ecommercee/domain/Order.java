package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;



@Entity(name ="ORDER")
public class Order {

    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private Cart cart;

    public Order(Long id, LocalDate orderDate) {
        this.id = id;
        this.orderDate = orderDate;
    }

    public Order() {
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    public Long getId() {

        return id;
    }

    @Column(name = "ORDER_DATE")
    public LocalDate getOrderDate() {

        return orderDate;
    }

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {

        return cart;
    }

    private void setId(Long id) {

        this.id = id;
    }

    private void setOrderDate(LocalDate orderDate) {

        this.orderDate = orderDate;
    }

    private void setCart(Cart cart) {

        this.cart = cart;
    }
}
