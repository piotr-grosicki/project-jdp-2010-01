package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    public User user;
    private List<Product> productList = new ArrayList<>();

    public Order(Long id, LocalDate orderDate, User user, List<Product> productList) {
        this.id = id;
        this.orderDate = orderDate;
        this.user = user;
        this.productList = productList;
<<<<<<< HEAD
    }

    public Order(LocalDate orderDate, User user, List<Product> productList) {
        this.orderDate = orderDate;
        this.user = user;
        this.productList = productList;
=======
>>>>>>> main
    }

    public Order(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Order() {
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

<<<<<<< HEAD

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
=======
    @ManyToOne
>>>>>>> main
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @ManyToMany(cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            })
    @JoinTable(
            name = "JOIN_ORDER_PRODUCT",
            joinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")}
    )
    public List<Product> getProductList() {

        return productList;
    }

    public void setProductList(List<Product> productList) {

        this.productList = productList;
    }

    public void setOrderDate(LocalDate orderDate) {
<<<<<<< HEAD
=======

>>>>>>> main
        this.orderDate = orderDate;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setUser(User user) {

        this.user = user;
    }
}
