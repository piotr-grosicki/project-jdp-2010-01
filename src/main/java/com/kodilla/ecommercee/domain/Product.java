package com.kodilla.ecommercee.domain;

import javax.persistence.*;

@Entity(name = "PRODUCT_ENTITY")

public class Product {


    private Long id;
    private String productName;
    public Group group;

    public Product(Long id, String productName, Group group) {
        this.id = id;
        this.productName = productName;
        this.group = group;
    }

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    @ManyToOne
    @JoinColumn(name = "GROUP_OF_PRODUCT")
    public Group getGroup() {
        return group;
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
