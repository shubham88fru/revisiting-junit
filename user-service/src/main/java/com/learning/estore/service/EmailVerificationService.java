package com.learning.estore.service;

import com.learning.estore.model.User;

public interface EmailVerificationService {

    void scheduleEmailConfirmation(User user);
}
