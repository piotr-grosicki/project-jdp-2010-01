package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    public Cart mapToCart(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getUserDto(),
                cartDto.getProductsInCart());
    }
    public CartDto maptoCartDto(Cart cart){
        return new CartDto(
                cart.getId(),
                cart.getUser(),
                cart.getProductsAddedToCart());
    }

    public List<CartDto> mapToCartDtoList(List<Cart> cartList) {
        return cartList.stream()
                .map(c -> new CartDto(c.getId(), c.getUser(), c.getProductsAddedToCart()))
                .collect(Collectors.toList());
    }
}
