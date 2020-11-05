package com.kodilla.ecommercee.productDao;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;

import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.GroupDao;
import com.kodilla.ecommercee.repository.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
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

    @Test
    public void saveProductOnDatabaseTestSuite() {
        //Given
        Product product = new Product("Test Product");
        productDao.save((product));
        //When
        Optional<Product> resultProduct = productDao.findById(product.getId());
        //Then
        Assert.assertNotEquals(0, resultProduct);
        //CleanUp
        try {
            productDao.deleteById(product.getId());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void saveProductOnDatabaseWithGroupTestSuite() {
        //Given
        Group group = new Group("Szlifierki Kątowe Bosch");
        Product product = new Product("Test Product");
        product.setGroup(group);
        productDao.save(product);
        //When
        List<Product> productList = productDao.findAll();
        List<Group> groupList = groupDao.findAll();

        //Then
        Assert.assertNotEquals(0, productList.size());
        Assert.assertNotEquals(0, groupList.size());
        //CleanUp
        try {
            productDao.deleteById(product.getId());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void saveProductOnDatabaseWithCartTestSuite() {
        //Given
        //
        Cart cart1 = new Cart(1L);
        Cart cart2 = new Cart(2L);
        Cart cart3 = new Cart(3L);
        Product product1 = new Product("Test Product 1");
        Product product2 = new Product("Test Product 2");
        Product product3 = new Product("Test Product 3");
        cart1.getProductsAddedToCart().add(product1);
        cart2.getProductsAddedToCart().add(product2);
        cart3.getProductsAddedToCart().add(product3);
        //When
        productDao.save(product1);
        long prduct1Id = product1.getId();
        productDao.save(product2);
        long prduct2Id = product1.getId();
        productDao.save(product3);
        long prduct3Id = product1.getId();
        //Then
        Assert.assertNotEquals(0, prduct1Id);
        Assert.assertNotEquals(0, prduct2Id);
        Assert.assertNotEquals(0, prduct3Id);
        //CleanUp
        try {
            productDao.deleteById(product1.getId());
            productDao.deleteById(product2.getId());
            productDao.deleteById(product3.getId());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void findProductByIdTestSuite() {
        //Given
        Product product1 = new Product("Test Product 1");
        Product product2 = new Product("Test Product 2");
        Product product3 = new Product("Test Product 3");
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);
        //When
        Long id = product1.getId();
        Optional<Product> resultProduct = productDao.findById(id);

        //Then
        Assert.assertTrue(resultProduct.isPresent());
        //CleanUp
        try {
            productDao.deleteById(id);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void deleteProductByIdTestSuite() {
        //Given
        Cart cart = new Cart(1l);
        Group group = new Group("Test group");
        Product product1 = new Product("Test Product1");
        product1.setGroup(group);
        cart.getProductsAddedToCart().add(product1);
        productDao.save(product1);

        //When
        Long id = product1.getId();
        productDao.deleteById(id);
        Optional<Product> resultProduct = productDao.findById(id);

        //Then
        Assert.assertFalse(resultProduct.isPresent());
        Assert.assertNotNull(cartDao.findById(cart.getId()));
        Assert.assertNotNull(groupDao.findById(group.getId()));

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
