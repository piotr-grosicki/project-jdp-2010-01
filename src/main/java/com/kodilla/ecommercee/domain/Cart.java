package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARTS")
public class Cart {

    private Long Id;
    private User user;
    //private List<Product> productsAddedToCart;
    private Order order;
    private List<Product> products = new ArrayList<>();

    public Cart(Long id, User user) {
        Id = id;
        this.user = user;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }



    @ManyToMany(cascade = CascadeType.ALL)
    @Column(name = "PRODUCTS_ADDED_TO_CART")
    public List<Product> getProducts() {
        return products;
    }



    public void setProducts(List<Product> products) {
        this.products = products;
    }



    private void setOrder(Order order) {
        this.order = order;
    }

    private void setId(Long id) {
        Id = id;
    }

    private void setUser(User user) {
        this.user = user;
    }

}
