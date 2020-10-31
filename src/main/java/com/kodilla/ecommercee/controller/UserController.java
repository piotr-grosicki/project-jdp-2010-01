package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserDbService service;

    UserMapper userMapper;
    UserDto userDto;

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam Long userId) {
        return userMapper.mapUserToUserDto(service.getUserById(userId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(userMapper.mapUserDtoToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "banUser")
    public UserDto banUser(@RequestParam long userId) {
        return userMapper.mapUserToUserDto(service.saveUser(userMapper.mapUserDtoToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUserKey")
    public String createUserKey(@RequestParam String username, @RequestParam String password) {
        return "QWERTY123";
    }

}
