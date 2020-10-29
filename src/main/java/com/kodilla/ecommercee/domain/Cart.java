package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "CARTS")
public class Cart {

    private Long Id;
    private User user;
    private List<Product> productsAddedToCart;
    private Order order;

    public Cart(Long id, User user, List<Product> productsAddedToCart) {
        Id = id;
        this.user = user;
        this.productsAddedToCart = productsAddedToCart;
    }

    public Cart() {
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    public Long getId() {
        return Id;
    }

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }


    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }


    private void setId(Long id) {
        Id = id;
    }

    private void setUser(User user) {
        this.user = user;
    }

    private void setProductsAddedToCart(List<Product> productsAddedToCart) {
        this.productsAddedToCart = productsAddedToCart;
    }

    private void setOrder(Order order) {
        this.order = order;
    }
}
