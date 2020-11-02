package com.kodilla.ecommercee.user.dao;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartDao;
import com.kodilla.ecommercee.repository.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTestSuite {
    @Autowired
    UserDao userDao;
    @Autowired
    CartDao cartDao;

    @Test
    public void saveUserOnDatabaseTestSuite() {
        //Given
        User user = new User(1L, "UserName", "1234", "plokijuh", true);
        userDao.save(user);

        //When
        List<User> resultList = userDao.findAll();



        //Then
        Assert.assertNotEquals(0, resultList.size());


    }

    @Test
    public void saveUserOnDatabaseWithCartTestSuite() {
        //Given
        User user = new User(1L, "UserName", "1234", "plokijuh", true);
        Cart cart = new Cart(2L);

        user.setCart(cart);

        userDao.save(user);

        //When
        List<User> userList = userDao.findAll();
        List<Cart> cartList = cartDao.findAll();

        //Then
        Assert.assertNotEquals(0, userList.size());
        Assert.assertNotEquals(0, cartList.size());

    }

   @Test
    public void findUserByIdTestSuite() {
        //Given
        User user = new User(1L, "UserName", "1", "plokijuh", true);
        User user2 = new User(2L, "UserName1", "2", "plokijuh", true);
        User user3 = new User(3L, "UserName2", "3", "plokijuh", true);
        User user4 = new User(4L, "UserName3", "4", "plokijuh", true);

        userDao.save(user);
        userDao.save(user2);
        userDao.save(user3);
        userDao.save(user4);

        //When
        Long id = user2.getId();
        Optional<User> findUser = userDao.findById(id);

        //Then
        Assert.assertTrue(findUser.isPresent());
    }

    @Test
    public void deleteUserByIdTestSuite() {
        //Given
        User usr1 = new User(1L, "UserName", "1", "plokijuh", true);
        User usr2 = new User(2L, "UserName1", "2", "plokijuh", true);
        User usr3 = new User(3L, "UserName2", "3", "plokijuh", true);
        User usr4 = new User(4L, "UserName3", "4", "plokijuh", true);
        User usr5 = new User(5L, "UserName3", "4", "plokijuh", true);

        userDao.save(usr1);
        userDao.save(usr2);
        userDao.save(usr3);
        userDao.save(usr4);
        userDao.save(usr5);

        //When
        List<User> usersBeforeDelete = userDao.findAll();
        Long id = 5L;
        userDao.deleteById(id);
        List<User> usersAfterDelete = userDao.findAll();

        //Then
        Assert.assertTrue(usersBeforeDelete.size() > usersAfterDelete.size());

    }

    @Test
    public void findUserByStatusTestSuite(){
        //Given
        User user = new User(1L, "UserName", "1", "plokijuh", true);
        User user2 = new User(2L, "UserName1", "2", "plokijuh", false);

        userDao.save(user);
        userDao.save(user2);

        //When
        List<User> users1 = userDao.findByActive(true);

        //Then
        Assert.assertNotEquals(0,users1.size());



    }
}
