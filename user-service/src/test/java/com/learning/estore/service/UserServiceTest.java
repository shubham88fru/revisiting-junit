package com.learning.estore.service;

import com.learning.estore.data.UsersRepository;
import com.learning.estore.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @Mock
    UsersRepository usersRepository;

    @BeforeEach
    void init() {
        firstName = "shubham";
        lastName = "singh";
        email = "test@test.com";
        password = "password";
        repeatPassword = "password";
    }

    @DisplayName("User object created")
    @Test
    public void testCreateUser_whenUserDetailsProvided_returnsUserObject() {

        when(usersRepository.save(any(User.class))).thenReturn(Boolean.TRUE);

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

        Mockito.verify(usersRepository, Mockito.times(1))
                .save(any(User.class));

    }

    @DisplayName("Empty first name causes correct exception")
    @Test
    public void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        // Arrange
        firstName = "";

        // Act and assert
        assertThrows(IllegalArgumentException.class, () -> userService.createUser(
                firstName, lastName, email, password, repeatPassword
        ), "Empty first name should have caused an Illegal argument exception.");

        // Assertions
    }

    @DisplayName("If save() method causes RuntimeException, a UserServiceException is thrown.")
    @Test
    public void testCreateUser_whenSaveMethodThrowsException_thenThrowsUserServiceException() {
        // Arrange
        when(usersRepository.save(any(User.class))).thenThrow(RuntimeException.class);

        // Act
        assertThrows(UserServiceException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);
        }, "Should have thrown UserServiceException instead");

        //Assert
    }
}
