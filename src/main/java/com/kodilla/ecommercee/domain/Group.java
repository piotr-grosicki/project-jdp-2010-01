package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "GROUP_ENTITY")
public class Group {

    private Long id;
    private String groupName;
    private List<Product> productList = new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUP_ID")
    public Long getId() {
        return id;
    }

    @Column(name = "PRODUCT_LIST")
    @OneToMany(targetEntity = Product.class, mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Product> getProductList() {
        return productList;
    }

    @Column(name = "GROUP_NAME")
    public String getGroupName() {
        return groupName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

