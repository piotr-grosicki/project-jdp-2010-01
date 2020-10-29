package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "CART")
public class Cart {
    private Long id;
    private String products;
    private Order order;

    public Cart(Long id, String products) {
        this.id = id;
        this.products = products;
    }

    public Cart() {
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID")
    public Long getId() {

        return id;
    }

    @Column(name = "PRODUCTS")
    public String getProducts() {

        return products;
    }

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setProducts(String products) {

        this.products = products;
    }

    public void setOrder(Order order) {

        this.order = order;
    }
}
