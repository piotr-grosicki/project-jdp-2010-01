package com.kodilla.ecommercee.productDao;

import com.kodilla.ecommercee.controller.GroupController;
import com.kodilla.ecommercee.controller.ProductController;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTestSuite {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    Gr productController;

    @Test
    public void classProductTest() {
        //Given
        Group group = new Group("Test Group", new ArrayList<>());
        Product product = new Product("Test", group);
        Group group1 = new Group("Test Group", new ArrayList<>());
        Product product1 = new Product("Test", group);

        //When
        groupRepository.save(group);
        groupRepository.save(group1);
        productRepository.save(product);
        productRepository.save(product1);
        long groupId = group.getId();
        long group1Id = group1.getId();
        long productId = product.getId();
        long product1Id = product1.getId();
        Optional <Product> productFindById = productRepository.findById(groupId);
        int listOfProductsSize = productRepository.findAll().size();

        //Then
        Assert.assertTrue(productFindById.isPresent());
        Assert.assertEquals(product, productFindById.isPresent());
        Assert.assertEquals(2, productRepository.findAll().size());
        productRepository.deleteById(product.getId());
        productRepository.deleteById(product1.getId());
        Assert.assertEquals(0,productRepository.findAll().size());

        //CleanUp
        try {
            productRepository.deleteById(productId);
            productRepository.deleteById(product1Id);
            groupRepository.deleteById(groupId);
            groupRepository.deleteById(group1Id);

        }catch (Exception e){
            //do nothing
        }
    }

}
