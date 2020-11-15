package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.repository.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDbService {
    @Autowired
    private CartDao cartDao;

    public List<Cart> getAllCarts() {
        return cartDao.findAll();
    }

    public Cart getCartById(final Long cartId) {
        return cartDao.findById(cartId).orElse(null);
    }

    public Cart saveCart(final Cart cart) {
        return cartDao.save(cart);
    }

    public void deleteCart(final Long cartId) {
        cartDao.deleteById(cartId);
    }
}
