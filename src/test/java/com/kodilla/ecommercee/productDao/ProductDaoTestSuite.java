package com.kodilla.ecommercee.productDao;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;

import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
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
    ProductRepository productRepository;
    @Autowired
    GroupRepository groupRepository;

    @Test
    public void saveProductOnDatabaseTestSuite() {
        //Given
        Product product = new Product("Test Product");
        productRepository.save((product));
        //When
        Optional<Product> resultProduct = productRepository.findById(product.getId());
        //Then
        Assert.assertNotEquals(0, resultProduct);
        //CleanUp
        try {
            productRepository.deleteById(product.getId());
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
        productRepository.save(product);
        //When
        List<Product> productList = productRepository.findAll();
        List<Group> groupList = groupRepository.findAll();

        //Then
        Assert.assertNotEquals(0, productList.size());
        Assert.assertNotEquals(0, groupList.size());
        //CleanUp
        try {
            productRepository.deleteById(product.getId());
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
        Product product1 = new Product("Test Product");
        Product product2 = new Product("Test Product");
        Product product3 = new Product("Test Product");
        cart1.getProductsAddedToCart().add(product1);
        cart2.getProductsAddedToCart().add(product2);
        cart3.getProductsAddedToCart().add(product3);
        //When
        productRepository.save(product1);
        long prduct1Id = product1.getId();
        productRepository.save(product2);
        long prduct2Id = product1.getId();
        productRepository.save(product3);
        long prduct3Id = product1.getId();
        //Then
        Assert.assertNotEquals(0, prduct1Id);
        Assert.assertNotEquals(0, prduct2Id);
        Assert.assertNotEquals(0, prduct3Id);
        //CleanUp
        try {
            productRepository.deleteById(product1.getId());
            productRepository.deleteById(product2.getId());
            productRepository.deleteById(product3.getId());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void findProductByIdTestSuite() {
        //Given
        Product product1 = new Product("Test Product1");
        Product product2 = new Product("Test Product2");
        Product product3 = new Product("Test Product3");
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        //When
        Long id = product1.getId();
        Optional<Product> resultProduct = productRepository.findById(id);

        //Then
        Assert.assertTrue(resultProduct.isPresent());
        //CleanUp
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void deleteProductByIdTestSuite() {
        //Given
        Product product1 = new Product("Test Product1");
        productRepository.save(product1);

        //When
        Long id = product1.getId();
        productRepository.deleteById(id);
        Optional<Product> resultProduct = productRepository.findById(id);
        //Then
        Assert.assertFalse(resultProduct.isPresent());
        //CleanUp
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            //do nothing
        }
    }
}
