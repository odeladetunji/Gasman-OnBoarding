package com.services;

import com.config.BeanGenerator;
import com.dao.AuthenticationRepository;
import com.dao.DistributorsRepository;
import com.dao.UserRepository;
import com.factory.AbstractFactory;
import com.factory.ProducerFactory;
import com.models.Authentication;
import com.models.Distributors;
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
    AuthenticationRepository authenticationRepository;

    @Autowired
    DistributorsRepository distributorsRepository;

    @Autowired
    UserRepository userRepository;

    public BeanGenerator getEntityObj(Authentication payload){
        beanGenerator.aUser().password = payload.password;
        beanGenerator.aUser().email = payload.email;

        return beanGenerator;
    }

    public BeanGenerator aDistributor(Distributors payload){
        beanGenerator.aDistributor().fullname = payload.fullname;
        beanGenerator.aDistributor().LocationOnMap = payload.LocationOnMap;
        beanGenerator.aDistributor().meansOfDelivery = payload.meansOfDelivery;
        beanGenerator.aDistributor().phoneNumber = payload.phoneNumber;
        beanGenerator.aDistributor().photographId = payload.photographId;

        return beanGenerator;
    }

    public BeanGenerator createUserObj(User payload){
        beanGenerator.createUserObj().fullname = payload.fullname;

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

    @Override
    public String distributorRegistration(Distributors payload){
        try {
            distributorsRepository.save(aDistributor(payload).aDistributor());
            return "Successfull";
        }catch (Exception ex){
            return "unsuccessfull";
        }
    }

    @Override
    public String userRegistration(User payload){
        try{
            userRepository.save(createUserObj(payload).createUserObj());
            return "successfull";
        }catch (Exception ex){
            return "unsuccessfull";
        }
    }

}
