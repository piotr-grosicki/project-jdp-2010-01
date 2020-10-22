package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(Long userId) {
        return new UserDto(1L, "Hanna Montana", "QWERTY1234", "password", false);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(UserDto userDto) {
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void banUser(Long userId) {
    }

}
