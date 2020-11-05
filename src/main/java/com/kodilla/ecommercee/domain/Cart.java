package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARTS")
public class Cart {
    private Long id;
    private User user;
    private List<Product> productsAddedToCart = new ArrayList<>();
    private Order order;

    public Cart(Long id, User user, List<Product> productsAddedToCart) {
        this.id = id;
        this.user = user;
        this.productsAddedToCart = productsAddedToCart;
    }

    public Cart() {
    }

    public Cart(Long id) {
        this.id = id;
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    public List<Product> getProductsAddedToCart() {
        return productsAddedToCart;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProductsAddedToCart(List<Product> productsAddedToCart) {
        this.productsAddedToCart = productsAddedToCart;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}