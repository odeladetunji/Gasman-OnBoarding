package com.config;

import com.entity.Authentication;
import com.entity.Distributors;
import com.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanGenerator {

    @Bean
    public Authentication aUser(){
        return new Authentication();
    }

    @Bean
    public Distributors aDistributor(){
        return new Distributors();
    }

    @Bean
    public User createUserObj(){
        return new User();
    }

}
