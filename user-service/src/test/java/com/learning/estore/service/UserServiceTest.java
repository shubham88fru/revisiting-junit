package com.learning.estore.service;

import com.learning.estore.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void testCreateUser_whenUserDetailsProvided_returnsUserObject() {
        //arrange
        UserService userService = new UserServiceImpl();
        String firstName = "shubham";
        String lastName = "singh";
        String email = "test@test.com";
        String password = "password";
        String repeatPassword = "password";

        //act
        User user = userService.createUser(firstName, lastName,
                email, password, repeatPassword);

        //assert
        Assertions.assertNotNull(user, "the createUser() message shouldn't have returned a null user.");
    }
}
