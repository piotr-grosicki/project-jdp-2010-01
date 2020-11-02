package com.kodilla.ecommercee.domain;

import java.util.List;

public class CartDto {
    private Long Id;
    private UserDto userDto;
    private List<ProductDto> productsInCart;

    public CartDto(Long id, UserDto userDto, List<ProductDto> productsInCart) {
        Id = id;
        this.userDto = userDto;
        this.productsInCart = productsInCart;
    }

    public CartDto() {
    }

    public Long getId() {
        return Id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public List<ProductDto> getProductsInCart() {
        return productsInCart;
    }
}

