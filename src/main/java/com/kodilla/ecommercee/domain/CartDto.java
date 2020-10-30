package com.kodilla.ecommercee.domain;

import java.util.List;

public class CartDto {
    private Long Id;
    private User user;
    private List<Product> productsInCart;

    public CartDto(Long id, User user, List<Product> productsInCart) {
        Id = id;
        this.user = user;
        this.productsInCart = productsInCart;
    }

    public Long getId() {
        return Id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }
}

