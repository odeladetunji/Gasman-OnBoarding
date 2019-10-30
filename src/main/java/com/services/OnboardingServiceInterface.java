package com.services;

import com.models.User;

public interface OnboardingServiceInterface {
    String Login(User payload);
    User getUser(User payload);
    String signUp(User payload);
}
