package com.learning.estore.data;

import com.learning.estore.model.User;

public interface UsersRepository {
    boolean save(User user);
}
