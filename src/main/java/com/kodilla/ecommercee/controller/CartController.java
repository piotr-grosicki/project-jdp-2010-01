package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/carts")
public class CartController {

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public CartDto getCart(@RequestParam Long cartId) {

        return new CartDto(1L, new UserDto(), new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCart")
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        return new CartDto(1L, new UserDto(), new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public void deleteCart(@RequestParam Long cartId) {
    }
}
