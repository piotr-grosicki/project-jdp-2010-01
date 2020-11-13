package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private Long id;
    private String productName;
    private Group group;
    private List<OrderDto> orderDtoList;

    public ProductDto(String productName) {
        this.productName = productName;
    }


}
