package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("v1/carts")
public class CartController {

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public CartDto getCart(@RequestParam Long cartId) {
        return new CartDto(1L, new HashMap<>());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestBody CartDto cartDto){
    }

    @RequestMapping(method =  RequestMethod.PUT, value = "updateCart")
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        return new CartDto(1L, new HashMap<>());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public void deleteCart(@RequestParam Long cartId) {
    }
}