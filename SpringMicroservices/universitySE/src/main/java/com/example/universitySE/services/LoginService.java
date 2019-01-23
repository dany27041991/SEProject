package com.example.universitySE.services;

import com.example.universitySE.exceptions.PersonNotLoggedInException;
import com.example.universitySE.exceptions.ProblemConnectionDbException;
import com.example.universitySE.intservices.LoginServiceInterface;
import com.example.universitySE.models.PersonModel;
import com.example.universitySE.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements LoginServiceInterface{

    private static final Logger log = LoggerFactory.getLogger(LoginServiceInterface.class);

    @Autowired
    PersonRepository personRepository;

    @Override
    public Optional<PersonModel> getPersonAndVerifyPassword(String username, String password) throws PersonNotLoggedInException{
        Optional<PersonModel> user = personRepository.findPersonByUsernameAndAndPassword(username, password);
        if(user.isPresent()) {
            log.info("Person correctly logged in!");
            return user;
        }
        else {
            log.info("Person not exist or wrong password!");
            throw new PersonNotLoggedInException("Person not correctly logged in! Try again!");
        }
    }
}
