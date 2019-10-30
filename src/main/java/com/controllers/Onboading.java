package com.controllers;

import com.models.Authentication;
import com.models.User;
import com.services.OnboardingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Onboading {

    @Autowired
    OnboardingServiceInterface onboardingServiceInterface;

    @ResponseBody
    @GetMapping(path = "/ping")
    public String ping(){
        return "ping successfull";
    }

    @ResponseBody
    @PostMapping(path = "/Gasman/Login")
    public String Login(@RequestBody Authentication payload){
       return onboardingServiceInterface.Login(payload);
    }

    @ResponseBody
    @PostMapping(path = "/Gasman/Signup")
    public String signUp(Authentication payload){
        return onboardingServiceInterface.signUp(payload);
    }
}
