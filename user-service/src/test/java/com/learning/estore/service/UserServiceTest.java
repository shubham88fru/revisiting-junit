package com.learning.estore.service;

import com.learning.estore.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @DisplayName("User object created")
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
        Assertions
                .assertNotNull(user,
                        "the createUser() message shouldn't have returned a null user.");

        Assertions.assertEquals(firstName,
                user.getFirstName(),
                "User's first name should match.");

        Assertions.assertEquals(lastName,
                user.getLastName(), "User's last name should match.");

        Assertions.assertEquals(email,
                user.getEmail(), "User's email should match.");

        Assertions.assertNotNull(user.getId(), "User id is missing");

    }
}
