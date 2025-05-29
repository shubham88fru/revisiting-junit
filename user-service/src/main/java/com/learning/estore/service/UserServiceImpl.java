package com.learning.estore.service;

import com.learning.estore.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    @Override
    public User createUser(String firstName, String lastName,
                           String email, String password, String repeatPassword) {

        if (firstName == null || lastName == null || email == null || password == null || repeatPassword == null) {
            throw new IllegalArgumentException("All required parameters are null");
        }

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || repeatPassword.length() == 0) {
            throw new IllegalArgumentException("All required parameters are empty");
        }

        return new User(
                firstName,
                lastName,
                email,
                UUID.randomUUID().toString()
        );
    }
}
