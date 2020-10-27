package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


@Getter

public class OrderDto {

    private Long id;
    private Long cartId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    public OrderDto(Long id, Long cartId, LocalDate orderDate) {
        this.id = id;
        this.cartId = cartId;
        this.orderDate = orderDate;
    }
}
