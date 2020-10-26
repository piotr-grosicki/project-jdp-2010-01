package com.kodilla.ecommercee.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long userId;
    private String userName;
    private String userKey;
    private String password;
    private boolean status;

}
