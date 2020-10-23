package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class OrderDto {

    private Long orderId;
    private Long cartId;
    private LocalDate orderDate;

}
