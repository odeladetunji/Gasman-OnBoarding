package com.factory;

import com.models.User;

public class EntityFactory extends AbstractFactory {
    @Override
    public User getUser(){
        return new User();
    }
}
