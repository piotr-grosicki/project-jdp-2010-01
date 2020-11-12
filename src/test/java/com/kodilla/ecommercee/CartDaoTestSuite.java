package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.OrderDao;
import com.kodilla.ecommercee.repository.ProductDao;
import com.kodilla.ecommercee.repository.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartDaoTestSuite {
    @Autowired
    CartDao cartDao;

    @Autowired
    UserDao userDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;

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

        //When
        cartDao.save(cart);
        Optional<Cart> result = cartDao.findById(cart.getId());
        Optional<User> userResult = userDao.findById(user.getId());

        //Then
        Assert.assertTrue(result.isPresent());
        Assert.assertTrue(userResult.isPresent());

        //CleanUp
        cartDao.deleteById(cart.getId());
        userDao.deleteById(user.getId());
    }

    @Test
    public void testCartDaoDeleteByIdWithUser() {
        //Given
        User user = new User("Piotr");
        Cart cart = new Cart(user, new ArrayList<>());
        cartDao.save(cart);

        //When
        List<Cart> cartsBeforeDelete = cartDao.findAll();
        List<User> usersBeforeDelete = userDao.findAll();
        cartDao.deleteById(cart.getId());
        List<Cart> cartsAfterDelete = cartDao.findAll();
        List<User> usersAfterDelete = userDao.findAll();

        //Then
        Assert.assertTrue(cartsBeforeDelete.size() > cartsAfterDelete.size());
        Assert.assertEquals(usersBeforeDelete.size(), usersAfterDelete.size());
    }

    @Test
    public void testCartDaoDeleteById() {
        //Given
        Cart cart = new Cart(new User("piotr"), new ArrayList<>());
        cartDao.save(cart);

        //When
        cartDao.deleteById(cart.getId());

        //Then
        Assert.assertFalse(cartDao.findById(cart.getId()).isPresent());
    }

    @Test
    public void testCartDaoWithProductSaveManyToMany() {

        //Given
        Cart cart1 = new Cart(new User("Piotr"), new ArrayList<>());
        Cart cart2 = new Cart(new User("user"), new ArrayList<>());
        Cart cart3 = new Cart(new User("admin"), new ArrayList<>());
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Product product3 = new Product("Product 3");

        cart1.getProductsAddedToCart().add(product1);
        cart2.getProductsAddedToCart().add(product2);
        cart2.getProductsAddedToCart().add(product3);
        cart3.getProductsAddedToCart().add(product1);
        cart3.getProductsAddedToCart().add(product2);
        cart3.getProductsAddedToCart().add(product3);

        product1.getCarts().add(cart1);
        product1.getCarts().add(cart3);
        product2.getCarts().add(cart2);
        product2.getCarts().add(cart3);
        product3.getCarts().add(cart1);
        product3.getCarts().add(cart2);
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

    @Test
    public void testCartDaoDeleteByIdWithProductSaveManyToMany() {
        //Given
        Cart cart1 = new Cart(new User("Piotr"), new ArrayList<>());
        Cart cart2 = new Cart(new User("user"), new ArrayList<>());
        Cart cart3 = new Cart(new User("admin"), new ArrayList<>());
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Product product3 = new Product("Product 3");

        cart1.getProductsAddedToCart().add(product1);
        cart2.getProductsAddedToCart().add(product2);
        cart2.getProductsAddedToCart().add(product3);
        cart3.getProductsAddedToCart().add(product1);
        cart3.getProductsAddedToCart().add(product2);
        cart3.getProductsAddedToCart().add(product3);

        product1.getCarts().add(cart1);
        product1.getCarts().add(cart3);
        product2.getCarts().add(cart2);
        product2.getCarts().add(cart3);
        product3.getCarts().add(cart1);
        product3.getCarts().add(cart2);
        product3.getCarts().add(cart3);

        cartDao.save(cart1);
        long cart1Id = cart1.getId();
        cartDao.save(cart2);
        long cart2Id = cart2.getId();
        cartDao.save(cart3);
        long cart3Id = cart3.getId();

        //When
        List<Cart> cartsBeforeDelete = cartDao.findAll();
        List<Product> productsBeforeDelete = productDao.findAll();
        cartDao.deleteById(cart1Id);
        cartDao.deleteById(cart2Id);

        List<Cart> cartsAfterDelete = cartDao.findAll();
        List<Product> productsAfterDelete = productDao.findAll();

        //Then
        Assert.assertTrue(cartsBeforeDelete.size() > cartsAfterDelete.size());
        Assert.assertEquals(productsBeforeDelete.size(), productsAfterDelete.size());

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

