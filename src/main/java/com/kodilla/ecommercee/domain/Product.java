package com.kodilla.ecommercee.domain;

import javax.persistence.*;

@Entity(name = "PRODUCT_ENTITY")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @ManyToOne
    @JoinColumn(name = "GROUP_OF_PRODUCT")
    public Group group;

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
