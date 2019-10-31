package com.services;

import com.models.Authentication;
import com.models.Distributors;
import com.models.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface OnboardingServiceInterface {
    String Login(Authentication payload);
    Authentication getUser(Authentication payload);
    String signUp(Authentication payload);
    String distributorRegistration(Distributors payload);
    String userRegistration(User payload);
}



























