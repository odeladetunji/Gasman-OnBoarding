package com.services;

import com.config.BeanGenerator;
import com.dao.UserRepository;
import com.factory.AbstractFactory;
import com.factory.ProducerFactory;
import com.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OnBoardingService implements OnboardingServiceInterface{

    BeanGenerator beanGenerator;

    @Autowired
    OnboardingServiceInterface onboardingServiceInterface;

    @Autowired
    UserRepository userRepository;

    public BeanGenerator getEntityObj(User payload){
        beanGenerator.aUser().password = payload.password;
        beanGenerator.aUser().username = payload.username;

        return beanGenerator;
    }

    public AbstractFactory getEntity(){
        AbstractFactory anEntity = ProducerFactory.newEntityFactory();
        return anEntity;
    }

    @Override
    public User getUser(User payload){
        Optional<com.entity.User> result = userRepository.findById(payload.Id);
        User aUser = getEntity().getUser();
        if (result.isPresent()) {
            aUser.password = result.get().password;
            aUser.username = result.get().username;
            return aUser;
        }

        return aUser;
    }


    @Override
    public String Login(User payload){
//       userRepository
        if(getUser(payload).username == null){
            return "user does not exist";
        }

        return "successfull";
    }

    @Override
    public String signUp(User payload){
        com.entity.User aUser = getEntityObj(payload).aUser();
        try{
            userRepository.save(aUser);
            return "successfully Signed Up";
        }catch(Exception ex){
            return "something went wrong";
        }
    }

}
