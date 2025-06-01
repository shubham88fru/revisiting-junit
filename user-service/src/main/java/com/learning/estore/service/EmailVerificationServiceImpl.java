package com.learning.estore.service;

import com.learning.estore.model.User;

public class EmailVerificationServiceImpl implements EmailVerificationService{
    @Override
    public void scheduleEmailConfirmation(User user) {
        // Put user details into the queue.
    }
}
