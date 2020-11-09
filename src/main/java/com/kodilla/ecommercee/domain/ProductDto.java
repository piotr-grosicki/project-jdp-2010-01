package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private Long id;
    private String productName;
    private Group group;

    public ProductDto(String productName) {
        this.productName = productName;
    }


}
