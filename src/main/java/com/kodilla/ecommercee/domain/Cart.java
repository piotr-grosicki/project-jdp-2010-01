package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "CARTS")
public class Cart {

    private Long Id;
    private Long userId;
    private List<Product> productsAddedToCart;
    //private Order order;

    public Cart(Long id, Long userId, List<Product> productsAddedToCart) {
        Id = id;
        this.userId = userId;
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
    @Column(name = "USER_ID")
   /* @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")*/
    public Long getUserId() {
        return userId;
    }


    /*@ManyToMany(cascade = CascadeType.ALL, mappedBy = "CARTS")
    public List<Product> getProductsAddedToCart() {
        return productsAddedToCart;
    }

    /*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    private void setOrder(Order order) {
        this.order = order;
    }*/

    private void setId(Long id) {
        Id = id;
    }

    private void setUserId(Long userId) {
        this.userId = userId;
    }

    private void setProductsAddedToCart(List<Product> productsAddedToCart) {
        this.productsAddedToCart = productsAddedToCart;
    }
}

