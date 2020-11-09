package com.kodilla.ecommercee.user.dao;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserDaoTestSuite {
    @Autowired
    UserDao userDao;
    @Autowired
    CartDao cartDao;

    @Test
    public void saveUserOnDatabaseTestSuite() {
        //Given
        User user = new User("UserName", "1234", "plokijuh", true);
        userDao.save(user);

        //When
        List<User> resultList = userDao.findAll();

        //Then
        Assert.assertNotEquals(0, resultList.size());

        //Clear
        for (User input : userDao.findAll()) {
            userDao.deleteById(input.getId());
        }
    }

    @Test
    public void saveUserOnDatabaseWithCartTestSuite() {
        //Given
        User user2 = new User("UserName", "1234", "plokijuh", true);
        Cart cart2 = new Cart();
        user2.setCart(cart2);
        userDao.save(user2);

        //When
        List<User> userList = userDao.findAll();
        List<Cart> cartList = cartDao.findAll();

        //Then
        Assert.assertNotEquals(0, userList.size());
        Assert.assertNotEquals(0, cartList.size());

        //Clear
        for (User input : userDao.findAll()) {
            userDao.deleteById(input.getId());
        }
    }

    @Test
    public void findUserByIdTestSuite() {
        //Given
        User user1 = new User("UserName", "1", "plokijuh", true);
        User user2 = new User("UserName1", "2", "plokijuh", true);
        userDao.save(user1);
        userDao.save(user2);

        //When
        Long id = user1.getId();
        Optional<User> findUser = userDao.findById(id);

        //Then
        Assert.assertTrue(findUser.isPresent());

        //Clear
        for (User input : userDao.findAll()) {
            userDao.deleteById(input.getId());
        }
    }

    @Test
    public void deleteUserByIdTestSuite() {
        //Given
        User user1 = new User("UserName", "1", "plokijuh", true);
        Cart cart = new Cart();
        user1.setCart(cart);
        userDao.save(user1);

        //When
        List<User> usersBeforeDelete = userDao.findAll();
        List<Cart> cartsBeforeDelete = cartDao.findAll();
        Long id1 = user1.getId();
        userDao.deleteById(id1);
        List<User> usersAfterDelete = userDao.findAll();
        List<Cart> cartsAfterDelete = cartDao.findAll();

        //Then
        Assert.assertTrue(usersBeforeDelete.size() > usersAfterDelete.size());
        Assert.assertTrue(cartsBeforeDelete.size() > cartsAfterDelete.size());

        //Clear
        for (User input : userDao.findAll()) {
            userDao.deleteById(input.getId());
        }
    }

    @Test
    public void findUserByStatusTestSuite() {
        //Given
        User user = new User("UserName", "1", "plokijuh", true);
        User user2 = new User("UserName1", "2", "plokijuh", false);

        userDao.save(user);
        userDao.save(user2);

        //When
        List<User> users1 = userDao.findByActive(true);

        //Then
        Assert.assertNotEquals(0, users1.size());

        //Clear
        for (User input : userDao.findAll()) {
            userDao.deleteById(input.getId());
        }
    }
}
