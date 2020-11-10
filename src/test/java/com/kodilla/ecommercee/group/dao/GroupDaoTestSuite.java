package com.kodilla.ecommercee.group.dao;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.GroupDao;
import com.kodilla.ecommercee.repository.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDaoTestSuite {

    @Autowired
    GroupDao groupDao;

    @Autowired
    ProductDao productDao;

    @Test
    public void createGroup() {
        //Given
        Group group = new Group();
        group.setGroupName("Chemia gospodarcza");

        //When
        groupDao.save(group);
        Optional<Group> readGroup = groupDao.findById(group.getId());

        //Then
        Assert.assertTrue(readGroup.isPresent());

        //CleanUp
        groupDao.deleteById(group.getId());
    }

    @Test
    public void saveProductsInGroupTest() {
        //Given
        Group group = new Group();
        group.setGroupName("Chemia gospodarcza");

        Product product1 = new Product("domestos");
        Product product2 = new Product("ludwik");

        group.getProductList().add(product1);
        group.getProductList().add(product2);

        //When
        groupDao.save(group);
        long groupId = group.getId();
        long product1Id = product1.getId();
        long product2Id = product2.getId();

        Optional<Group> readGroup = groupDao.findById(groupId);
        Optional<Product> readProduct = productDao.findById(product1Id);
        Optional<Product> readProduct2 = productDao.findById(product2Id);

        //Then
        Assert.assertTrue(readGroup.isPresent());
        Assert.assertTrue(readProduct.isPresent());
        Assert.assertTrue(readProduct2.isPresent());

        //CleanUp
        groupDao.deleteById(groupId);
        productDao.deleteById(product1Id);
    }

    @Test
    public void deleteGroupTest() {

        //Given
        Group group = new Group();
        group.setGroupName("Chemia gospodarcza");

        groupDao.save(group);
        long id = group.getId();

        //When
        groupDao.deleteById(id);
        Optional<Group> readGroup = groupDao.findById(id);

        //Then
        Assert.assertFalse(readGroup.isPresent());
    }

}
