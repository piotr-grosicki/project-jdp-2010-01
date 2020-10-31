package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "GROUP_ENTITY")
public class Group {

    private Long id;
    private String groupName;
    private List<Product> productList = new ArrayList<>();

    public Group(@NotNull Long id, String groupName, List<Product> productList) {
        this.id = id;
        this.groupName = groupName;
        this.productList = productList;
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

    @Column(name = "GROUP_NAME")
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Column(name = "PRODUCT_LIST")
    @OneToMany(targetEntity = Product.class, mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Product> getProductList() {
        return productList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

