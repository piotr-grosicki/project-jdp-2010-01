package com.kodilla.ecommercee.productDao;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.GroupDao;
import com.kodilla.ecommercee.repository.ProductDao;

import com.kodilla.ecommercee.repository.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTestSuite {
    @Autowired
    ProductDao productDao;
    @Autowired
    GroupDao groupDao;
    @Autowired
    CartDao cartDao;
    @Autowired
    UserDao userDao;

    @Test
    public void saveProductOnDatabase() {
        //Given
        Product product = new Product("Test Product 1");
        productDao.save((product));
        //When
        Optional<Product> resultProduct = productDao.findById(product.getId());
        //Then
        Assert.assertTrue(resultProduct.isPresent());
        //CleanUp
        try {
            productDao.deleteById(product.getId());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void saveProductOnDatabaseWithGroup() {
        //Given
        Group group = new Group("Test Product");
        Product product = new Product("Test Product");
        product.setGroup(group);
        productDao.save(product);

        //When
        Optional<Product> productResult = productDao.findById(product.getId());
        Optional<Group> groupResult = groupDao.findById(group.getId());

        //Then
        Assert.assertTrue(productResult.isPresent());
        Assert.assertTrue(groupResult.isPresent());

        //CleanUp
        try {
            productDao.deleteById(product.getId());
            groupDao.deleteById(group.getId());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void saveProductOnDatabaseWithCart() {
        //Given
        User user1 = new User ("Jan");
        User user2 = new User ("Adam");
        User user3 = new User ("Janina");

        Cart cart1 = new Cart(user1);
        Cart cart2 = new Cart(user2);
        Cart cart3 = new Cart(user3);

        Product product1 = new Product("Test Product 1");
        Product product2 = new Product("Test Product 2");
        Product product3 = new Product("Test Product 3");

        product1.getCarts().add(cart1);
        product2.getCarts().add(cart2);
        product3.getCarts().add(cart3);

        //When
        productDao.save(product1);
        long prduct1Id = product1.getId();
        productDao.save(product2);
        long prduct2Id = product1.getId();
        productDao.save(product3);
        long prduct3Id = product1.getId();
        long cart1Id = cart1.getId();

        Optional<Cart> cartResult= cartDao.findById(cart1Id);

        Optional<Product> product1Result = productDao.findById(prduct1Id);
        Optional<Product> product2Result = productDao.findById(prduct2Id);
        Optional<Product> product3Result = productDao.findById(prduct3Id);

        //Then
        Assert.assertTrue(cartResult.isPresent());
        Assert.assertTrue(product1Result.isPresent());
        Assert.assertTrue(product2Result.isPresent());
        Assert.assertTrue(product3Result.isPresent());

        //CleanUp
        try {
            productDao.deleteById(product1.getId());
            productDao.deleteById(product2.getId());
            productDao.deleteById(product3.getId());
            cartDao. deleteById(cart1.getId());
            cartDao. deleteById(cart2.getId());
            cartDao. deleteById(cart3.getId());
            userDao.deleteById(user1.getId());
            userDao.deleteById(user2.getId());
            userDao.deleteById(user3.getId());

        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void findProductById() {
        //Given
        Product product1 = new Product("Test Product 1");
        Product product2 = new Product("Test Product 2");
        Product product3 = new Product("Test Product 3");

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        //When
        Long id1 = product1.getId();
        Long id2 = product2.getId();
        Long id3 = product3.getId();
        Optional<Product> productResult1 = productDao.findById(id1);
        Optional<Product> productResult2 = productDao.findById(id2);
        Optional<Product> productResult3 = productDao.findById(id3);

        //Then
        Assert.assertTrue(productResult1.isPresent());
        Assert.assertTrue(productResult2.isPresent());
        Assert.assertTrue(productResult3.isPresent());

        //CleanUp
        try {
            productDao.deleteById(id1);
            productDao.deleteById(id2);
            productDao.deleteById(id3);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void deleteProductById() {
        //Given
        User user = new User("Adam");
        Cart cart = new Cart(user);
        Group group = new Group("Test group");
        Product product1 = new Product("Test Product1");

        product1.setGroup(group);
        cart.getProductsAddedToCart().add(product1);
        product1.getCarts().add(cart);
        productDao.save(product1);

        Long id = product1.getId();
        Long cartId = cart.getId();
        Long groupId = group.getId();

        //When
        productDao.deleteById(id);

        Optional<Product> resultProduct = productDao.findById(id);
        Optional<Cart> resultCart = cartDao.findById(cartId);
        Optional<Group> resultGroup = groupDao.findById(groupId);

        //Then
        Assert.assertFalse(resultProduct.isPresent());
        Assert.assertTrue(resultCart.isPresent());
        Assert.assertTrue(resultGroup.isPresent());

        //CleanUp
        try {
            productDao.deleteById(id);
            cartDao.deleteById(cart.getId());
            groupDao.deleteById(group.getId());

        } catch (Exception e) {
            //do nothing
        }
    }
}
