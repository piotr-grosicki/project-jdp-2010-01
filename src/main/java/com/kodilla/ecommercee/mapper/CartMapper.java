package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    ProductMapper productMapper;
    UserMapper userMapper;

    public Cart mapToCart(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                userMapper.mapUserDtoToUser(cartDto.getUserDto()),
                productMapper.mapToProductList(cartDto.getProductsInCart()));
    }

    public CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                userMapper.mapUserToUserDto(cart.getUser()),
                productMapper.mapToProductDtoList(cart.getProductsAddedToCart()));
    }

    public List<CartDto> mapToCartDtoList(List<Cart> cartList) {
        return cartList.stream()
                .map(c -> new CartDto(c.getId(), userMapper.mapUserToUserDto(c.getUser()), productMapper.mapToProductDtoList(c.getProductsAddedToCart())))
                .collect(Collectors.toList());
    }
}
