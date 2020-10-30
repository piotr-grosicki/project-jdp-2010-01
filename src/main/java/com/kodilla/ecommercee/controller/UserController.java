package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserDbService service;

    UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam Long userId) {
        return new UserDto(1L, "Hanna Montana", "QWERTY1234", "password", false);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(userMapper.mapUserDtoToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "banUser")
    public void banUser(@RequestParam long userId) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUserKey")
    public String createUserKey(@RequestParam String username, @RequestParam String password) {
        return "QWERTY123";
    }

}
