package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class Cart {
    private Long Id;
    // private User user; nie wiem czy powinien się pojawić tu czy dopiero w Order?
    private Map<Product, Integer> productsAddedToCart ;
}
