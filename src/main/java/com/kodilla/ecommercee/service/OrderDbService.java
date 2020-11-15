package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.GroupDao;
import com.kodilla.ecommercee.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDbService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public Order getOrderById(final long orderId) {
        return orderDao.findById(orderId).orElse(null);
    }

    public Order saveOrder(final Order order) {
        return orderDao.save(order);
    }

    public void deleteOrder(final long orderId) {
        orderDao.deleteById(orderId);
    }
}
