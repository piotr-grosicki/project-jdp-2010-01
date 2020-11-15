package com.kodilla.ecommercee.order.dao;

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
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTestSuite {
    @Autowired
    OrderDao orderDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ProductDao productDao;


    @Test
    public void testOrderDaoFindAll() {

        //Given
        Order order1 = new Order(LocalDate.of(2000,1,1));
        orderDao.save(order1);
        Long id = order1.getId();

        //When
        List<Order> ordersList = orderDao.findAll();

        //Then
        Assert.assertNotEquals(0,ordersList.size());

        //CleanUp
        orderDao.deleteById(id);
    }

    @Test
    public void testSaveWithUser() {

        //Given
        User user = new User("Johnny");
        Order order = new Order(LocalDate.of(1990,1,1), user, new ArrayList<>());
        orderDao.save(order);

        //When
        Optional<Order> resultOrder = orderDao.findById(order.getId());
        Optional<User> resultUser = userDao.findById(user.getId());

        //Then
        Assert.assertTrue(resultOrder.isPresent());
        Assert.assertTrue(resultUser.isPresent());

        //CleanUp
        orderDao.deleteById(order.getId());
        userDao.deleteById(user.getId());
    }

    @Test
    public void testSaveWithProduct() {
        //Given
        User user1 = new User("Johnny1");
        User user2 = new User("Johnny2");
        User user3 = new User("Johnny3");

        Order order1 = new Order(LocalDate.of(1990,1,1),user1, new ArrayList<>());
        Order order2 = new Order(LocalDate.of(1980,1,1),user2, new ArrayList<>());
        Order order3 = new Order(LocalDate.of(1970,1,1),user3, new ArrayList<>());

        Product product1 = new Product("Product1");
        Product product2 = new Product("Product2");
        Product product3 = new Product("Product3");

        order1.getProductList().add(product1);
        order2.getProductList().add(product1);
        order2.getProductList().add(product3);
        order2.getProductList().add(product1);
        order3.getProductList().add(product2);
        order3.getProductList().add(product3);

        product1.getOrders().add(order1);
        product1.getOrders().add(order2);
        product1.getOrders().add(order3);
        product2.getOrders().add(order3);
        product3.getOrders().add(order2);
        product3.getOrders().add(order3);

        //When
        orderDao.save(order1);
        long order1Id = order1.getId();
        orderDao.save(order2);
        long order2Id = order2.getId();
        orderDao.save(order3);
        long order3Id = order3.getId();

        //Then

        Assert.assertNotEquals(0,order1Id);
        Assert.assertNotEquals(0,order2Id);
        Assert.assertNotEquals(0,order3Id);

        //CleanUp
        orderDao.deleteById(order1Id);
        orderDao.deleteById(order2Id);
        orderDao.deleteById(order3Id);
    }

    @Test
    public void deleteById() {

        //Given
        User user = new User("Johnny");
        Order order = new Order(LocalDate.of(2000,1,1), user, new ArrayList<>());
        orderDao.save(order);

        //When
        List<Order> ordersBeforeDelete = orderDao.findAll();
        List<User> usersBeforeDelete = userDao.findAll();
        orderDao.deleteById(order.getId());
        List<Order> ordersAfterDelete = orderDao.findAll();
        List<User> usersAfterDelete = userDao.findAll();

        //Then
        Assert.assertTrue(ordersBeforeDelete.size() > ordersAfterDelete.size());
        Assert.assertEquals(usersBeforeDelete.size(),usersAfterDelete.size());
    }

    @Test
    public void testDeleteByIdOrderWithProduct() {
        //Given
        User user1 = new User("Johnny1");
        User user2 = new User("Johnny2");
        User user3 = new User("Johnny3");

        Order order1 = new Order(LocalDate.of(1990,1,1),user1, new ArrayList<>());
        Order order2 = new Order(LocalDate.of(1980,1,1),user2, new ArrayList<>());
        Order order3 = new Order(LocalDate.of(1970,1,1),user3, new ArrayList<>());

        Product product1 = new Product("Product1");
        Product product2 = new Product("Product2");
        Product product3 = new Product("Product3");

        order1.getProductList().add(product1);
        order2.getProductList().add(product1);
        order2.getProductList().add(product3);
        order2.getProductList().add(product1);
        order3.getProductList().add(product2);
        order3.getProductList().add(product3);

        product1.getOrders().add(order1);
        product1.getOrders().add(order2);
        product1.getOrders().add(order3);
        product2.getOrders().add(order3);
        product3.getOrders().add(order2);
        product3.getOrders().add(order3);

        orderDao.save(order1);
        long order1Id = order1.getId();
        orderDao.save(order2);
        long order2Id = order2.getId();
        orderDao.save(order3);
        long order3Id = order3.getId();

        //When

        List<Order> ordersBeforeDelete = orderDao.findAll();
        List<Product> productsBeforeDelete = productDao.findAll();
        orderDao.deleteById(order1Id);
        orderDao.deleteById(order2Id);
        List<Order> ordersAfterDelete = orderDao.findAll();
        List<Product> productsAfterDelete = productDao.findAll();

        Assert.assertTrue(ordersBeforeDelete.size() > ordersAfterDelete.size());
        Assert.assertEquals(productsBeforeDelete.size(),productsAfterDelete.size());

        //CleanUp
        orderDao.deleteById(order3Id);
    }

}
