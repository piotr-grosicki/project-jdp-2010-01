package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDbService {

    @Autowired
    private UserRepository repository;

    public User banUser(long userId) {
        User user = getUserById(userId);
        user.setActive(false);
        saveUser(user);
        log.info(user.getUserName() + " has been formally forbidden");
        return user;
    }

    public User getUserById(final Long id) {
        return repository.findById(id).orElse(null);
    }

    public User saveUser(final User user) {
        return repository.save(user);
    }

    private String generateOneTimeKey(User user) {
        String key = RandomString.make(20);
        user.setUserKey(key);
        log.info("One time key for " + user.getUserName() + " is: " + key);
        return key;
    }

    public void deleteUser(final Long id) {
    }
}
