package com.kodilla.ecommercee.order.dao;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.repository.OrderDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTestSuite {
    @Autowired
    OrderDao orderDao;




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
    public void testDeleteById() {
        Cart cart3 = new Cart();
        Order order3 = new Order(LocalDate.of(1990,1,1));
        order3.setCart(cart3);
        orderDao.save(order3);

        //When
        Long id = order3.getId();
        orderDao.deleteById(id);

        //Then
        Assert.assertFalse(orderDao.findById(id).isPresent());
    }

}
