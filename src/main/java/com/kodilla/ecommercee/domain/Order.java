package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "ORDERS")
public class Order {

    private Long id;
    private Long cartId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private Cart cart;

    public Order(Long id, Long cartId, LocalDate orderDate) {
        this.id = id;
        this.cartId = cartId;
        this.orderDate = orderDate;
    }

    public Order() {
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Cart getCart() {
        return cart;
    }

    private void setCart(Cart cart) {
        this.cart = cart;
    }
}
