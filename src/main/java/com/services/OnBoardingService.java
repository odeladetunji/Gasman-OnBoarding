package com.services;

import com.config.BeanGenerator;
import com.dao.AuthenticationRepository;
import com.factory.AbstractFactory;
import com.factory.ProducerFactory;
import com.models.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OnBoardingService implements OnboardingServiceInterface{

    BeanGenerator beanGenerator;

    @Autowired
    OnboardingServiceInterface onboardingServiceInterface;

    @Autowired
    AuthenticationRepository authenticationRepository;

    public BeanGenerator getEntityObj(Authentication payload){
        beanGenerator.aUser().password = payload.password;
        beanGenerator.aUser().email = payload.email;

        return beanGenerator;
    }

    public AbstractFactory getEntity(){
        AbstractFactory anEntity = ProducerFactory.newEntityFactory();
        return anEntity;
    }

    @Override
    public Authentication getUser(Authentication payload){
        Optional<com.entity.Authentication> result = authenticationRepository.findById(payload.Id);
        Authentication aUser = getEntity().getUser();
        if (result.isPresent()) {
            aUser.password = result.get().password;
            aUser.email = result.get().email;
            return aUser;
        }

        return aUser;
    }


    @Override
    public String Login(Authentication payload){
        if(getUser(payload).email == null){
            return "user does not exist";
        }

        return "successfull";
    }

    @Override
    public String signUp(Authentication payload){
        com.entity.Authentication aUser = getEntityObj(payload).aUser();
        try{
            authenticationRepository.save(aUser);
            return "successfully Signed Up";
        }catch(Exception ex){
            return "something went wrong";
        }
    }

}
