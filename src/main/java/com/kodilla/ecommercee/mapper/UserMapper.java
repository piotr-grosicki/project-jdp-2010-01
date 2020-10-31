package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public User mapUserDtoToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getUserKey(),
                userDto.isStatus()
        );
    }

    public UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getUserKey(),
                user.isActive()
        );
    }

}
