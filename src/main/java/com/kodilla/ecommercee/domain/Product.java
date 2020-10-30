package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @ManyToOne
    @JoinColumn(name = "GROUP_OF_PRODUCT")
    public Group group;

    private List<Cart> carts = new ArrayList<>();

    public Product(Long id, String productName, Group group) {
        this.id = id;
        this.productName = productName;
        this.group = group;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Group getGroup() {
        return group;
    }



    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "PRODUCTS_ADDED_TO_CART")
   /* @JoinTable(
            name = "JOIN_CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "ID")}
    )*/

    @Column(name = "CARTS_LIST")
    public List<Cart> getCarts() {
        return new ArrayList<>(carts);
    }




    private void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
