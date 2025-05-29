package com.learning.estore.service;

import com.learning.estore.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    UserService userService;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void init() {
        userService = new UserServiceImpl();
        firstName = "shubham";
        lastName = "singh";
        email = "test@test.com";
        password = "password";
        repeatPassword = "password";
    }

    @DisplayName("User object created")
    @Test
    public void testCreateUser_whenUserDetailsProvided_returnsUserObject() {

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

    @DisplayName("Empty first name causes correct exception")
    @Test
    public void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        // Arrange
        firstName = "";

        // Act and assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.createUser(
                firstName, lastName, email, password, repeatPassword
        ), "Empty first name should have caused an Illegal argument exception.");

        // Assertions
    }
}
