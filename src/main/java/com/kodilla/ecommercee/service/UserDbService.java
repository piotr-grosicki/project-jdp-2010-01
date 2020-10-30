package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDbService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(final Long id) {
        return repository.findById(id).orElse(null);
    }

    public User saveUser(final User user) {
        return repository.save(user);
    }

    public void deleteUser(final Long id) {
    }
}
