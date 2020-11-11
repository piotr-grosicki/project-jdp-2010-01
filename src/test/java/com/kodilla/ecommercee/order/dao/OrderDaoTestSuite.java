package com.kodilla.ecommercee.order.dao;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.OrderDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTestSuite {
    @Autowired
    OrderDao orderDao;
    @Autowired
    CartDao cartDao;


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
    public void testFindByIdOrderWithCart() {
        //Given
        Cart cart2 = new Cart();
        Order order2 = new Order(LocalDate.of(1970, 5, 16));
        order2.setCart(cart2);
        orderDao.save(order2);


        //When
        Long id = order2.getId();
        Optional<Order> result = orderDao.findById(id);

        //Then
        Assert.assertTrue(result.isPresent());

        //CleanUp
        orderDao.deleteById(id);
    }

    @Test
    public void saveOrderWithCart() {
        //Given
        Cart cart3 = new Cart();
        Order order3 = new Order(LocalDate.of(1995,1,1));
        order3.setCart(cart3);
        orderDao.save(order3);

        //When
        List<Order> orders = orderDao.findAll();
        List<Cart> carts = cartDao.findAll();

        //Then
        Assert.assertNotEquals(0,orders.size());
        Assert.assertNotEquals(0,carts.size());

        //CleanUp
        Long id = order3.getId();
        orderDao.deleteById(id);

    }


    @Test
    public void testDeleteById() {
        Cart cart4 = new Cart();
        Order order4 = new Order(LocalDate.of(1990,1,1));
        order4.setCart(cart4);
        orderDao.save(order4);

        //When
        List<Order> orders = orderDao.findAll();
        List<Cart> carts = cartDao.findAll();
        Long id = order4.getId();
        orderDao.deleteById(id);
        List<Order> ordersAfterDeleteOrder = orderDao.findAll();
        List<Cart> cartsAfterDeleteOrder = cartDao.findAll();

        //Then
        Assert.assertTrue(orders.size() > ordersAfterDeleteOrder.size());
        Assert.assertTrue(carts.size() > cartsAfterDeleteOrder.size());
    }

}
