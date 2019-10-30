package com.config;

import com.entity.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanGenerator {

    @Bean
    public Authentication aUser(){
        return new Authentication();
    }

}
