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

}
