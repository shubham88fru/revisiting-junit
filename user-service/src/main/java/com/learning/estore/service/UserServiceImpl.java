package com.learning.estore.service;

import com.learning.estore.data.UsersRepository;
import com.learning.estore.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User createUser(String firstName, String lastName,
                           String email, String password, String repeatPassword) {

        if (firstName == null || lastName == null || email == null
                || password == null || repeatPassword == null) {
            throw new IllegalArgumentException("All required parameters are null");
        }

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()
                || password.isEmpty() || repeatPassword.isEmpty()) {
            throw new IllegalArgumentException("All required parameters are empty");
        }

        User user = new User(
                firstName,
                lastName,
                email,
                UUID.randomUUID().toString()
        );

        if (!usersRepository.save(user)) {
            throw new UserServiceException("Couldn't create user");
        }

        return user;
    }
}
