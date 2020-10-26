package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


@Getter

public class Order {

    private Long id;
    private Long cartId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    public Order(Long id, Long cartId, LocalDate orderDate) {
        this.id = id;
        this.cartId = cartId;
        this.orderDate = orderDate;
    }

}
