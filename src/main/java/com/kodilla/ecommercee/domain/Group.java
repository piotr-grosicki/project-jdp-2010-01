package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "groupTable")
public class Group {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "groupId")
    private Long id;
    @Column(name = "groupName")
    private String groupName;

    @Column(name = "productsList")
    @OneToMany(targetEntity = Product.class, mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList = new ArrayList<>();

}
