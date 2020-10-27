package com.kodilla.ecommercee.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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


}
