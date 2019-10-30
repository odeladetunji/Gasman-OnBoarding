package com.factory;

import com.models.Authentication;

public class EntityFactory extends AbstractFactory {
    @Override
    public Authentication getUser(){
        return new Authentication();
    }
}
