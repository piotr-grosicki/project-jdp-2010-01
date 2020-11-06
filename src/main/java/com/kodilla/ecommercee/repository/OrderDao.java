package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDao extends CrudRepository<Order, Long> {
    @Override
    List<Order> findAll();

    @Override
    Optional<Order> findById(Long id);

    @Override
    Order save(Order order);

    @Override
    void deleteById(Long id);
}
