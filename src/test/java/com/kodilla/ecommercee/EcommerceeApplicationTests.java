package com.kodilla.ecommercee;

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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EcommerceeApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void contextLoads() {
    }
    @Test
    public void productTest() {
        //Given
        Group group = new Group(1L, "Test Group",new ArrayList<>());
        Product product = new Product(1L,"Test",group);

        //When
        groupRepository.save(group);
        productRepository.save(product);
        long id = product.getId();

        //Then
        Assert.assertNotEquals(0,id);
    }
}

