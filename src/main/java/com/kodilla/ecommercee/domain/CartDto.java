package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class CartDto {
    private Long Id;
/*    private User user; nie wiem czy powinien się pojawić tu czy dopiero w Order,
    bo do koszyka można wkladać nie będąc zalogowanym?*/
    private Map<ProductDto, Integer> productsInCart;
}
