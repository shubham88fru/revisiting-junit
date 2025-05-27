package com.learning.estore.service;

import com.learning.estore.model.User;

public interface UserService {
    User createUser(String firstName, String lastName, String email,
                    String password, String repeatPassword);
}
