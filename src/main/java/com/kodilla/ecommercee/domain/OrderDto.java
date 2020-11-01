package com.kodilla.ecommercee.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private CartDto cartDto;


}
