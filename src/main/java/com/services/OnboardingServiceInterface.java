package com.services;

import com.models.Authentication;
import com.models.User;

public interface OnboardingServiceInterface {
    String Login(Authentication payload);
    Authentication getUser(Authentication payload);
    String signUp(Authentication payload);
}
