package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@Getter

public class Order {

    private Long Id;
    private Long cartId;
    private LocalDate orderDate;

    public Order(Long id, Long cartId, int year, int month, int day) {
        this.Id = id;
        this.cartId = cartId;
        this.orderDate = LocalDate.of(year,month,day);
    }

}
