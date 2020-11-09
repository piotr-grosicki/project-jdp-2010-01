package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GroupDto {
    private Long id;
    private String groupName;
    private List<Product> productList;

    public GroupDto(String groupName) {
        this.groupName = groupName;
    }
  
    public GroupDto(Long id, String groupName, List<Product> productList) {
        this.id = id;
        this.groupName = groupName;
        this.productList = productList;
    }
}
