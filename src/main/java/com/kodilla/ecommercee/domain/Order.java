package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class Order {

    private Long orderId;
    private Long cartId;
    private LocalDate orderDate;

}
