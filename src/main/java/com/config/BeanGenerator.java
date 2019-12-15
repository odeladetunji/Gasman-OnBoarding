package com.config;

import com.entity.Authentication;
import com.entity.Distributors;
import com.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class BeanGenerator {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

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
















