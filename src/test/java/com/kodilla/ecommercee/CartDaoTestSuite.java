package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.CartDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartDaoTestSuite {
    @Autowired
    CartDao cartDao;

    @Test
    public void testCartDaoFindAll() {

        //Given
        Cart cart = new Cart(new User("Piotr"), new ArrayList<>());
        cartDao.save(cart);

        //When
        List<Cart> resultList = cartDao.findAll();

        //Then
        Assert.assertNotEquals(0, resultList.size());

        //CleanUp
        cartDao.deleteById(cart.getId());
    }

    @Test
    public void testCartDaoSaveAndFindByIdAndSaveWithUser() {

        //Given
        User user = new User("Piotr");
        Cart cart = new Cart(user, new ArrayList<>());
        cart.setUser(user);

        //When
        cartDao.save(cart);
        Optional<Cart> result = cartDao.findById(cart.getId());

        //Then
        Assert.assertTrue(result.isPresent());

        //CleanUp
        cartDao.deleteById(cart.getId());
    }

    @Test
    public void testCartDaoDeleteById() {
        //Given
        Cart cart = new Cart(new User("piotr"), new ArrayList<>());
        cartDao.save(cart);

        User piotr = new User("Piotr");
        cart.setUser(piotr);

        //When
        cartDao.deleteById(cart.getId());

        //Then
        Assert.assertFalse(cartDao.findById(cart.getId()).isPresent());
    }

    @Test
    public void testCartDaoSaveWithOrder() {
        //Given
        Cart cart = new Cart(new User("piotr"), new ArrayList<>());
        cartDao.save(cart);
        cart.setOrder(new Order(LocalDate.of(2020, 10, 27)));

        //When
        cartDao.save(cart);

        //Then
        Assert.assertNotEquals(0, cartDao.findById(cart.getId()));

        //CleanUp
        cartDao.deleteById(cart.getId());
    }

    @Test
    public void testCartWithProductSaveManyToMany() {
        //Given
        Cart cart1 = new Cart(new User("Piotr"), new ArrayList<>());
        Cart cart2 = new Cart(new User("user"), new ArrayList<>());
        Cart cart3 = new Cart(new User("admin"), new ArrayList<>());
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Product product3 = new Product("Product 3");

        cart1.getProductsAddedToCart().add(product1);
        cart2.getProductsAddedToCart().add(product2);
        cart3.getProductsAddedToCart().add(product3);

        product1.getCarts().add(cart1);
        product2.getCarts().add(cart2);
        product3.getCarts().add(cart3);

        //When
        cartDao.save(cart1);
        long cart1Id = cart1.getId();
        cartDao.save(cart2);
        long cart2Id = cart2.getId();
        cartDao.save(cart3);
        long cart3Id = cart3.getId();


        //Then
        Assert.assertNotEquals(0, cart1Id);
        Assert.assertNotEquals(0, cart2Id);
        Assert.assertNotEquals(0, cart3Id);

        //CleanUp
        try {
            cartDao.deleteById(cart1Id);
            cartDao.deleteById(cart2Id);
            cartDao.deleteById(cart3Id);
        } catch (Exception e) {
            //do nothing
        }
    }
}
