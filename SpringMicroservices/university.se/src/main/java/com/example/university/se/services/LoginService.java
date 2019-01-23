package com.example.university.se.services;

import com.example.university.se.exceptions.PersonNotLoggedInException;
import com.example.university.se.intservices.LoginServiceInterface;
import com.example.university.se.models.PersonModel;
import com.example.university.se.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements LoginServiceInterface{

    private static final Logger log = LoggerFactory.getLogger(LoginServiceInterface.class);

    @Autowired
    PersonRepository personRepository;

    @Override
    public Optional<PersonModel> getPersonAndVerifyPassword(String username, String password) throws PersonNotLoggedInException {
        Optional<PersonModel> userr = personRepository.findPersonByUsernameAndAndPassword(username, password);
        if(userr.isPresent()) {
            log.info("Person correctly logged in!");
            return userr;
        }
        else {
            log.info("Person not exist or wrong password!");
            throw new PersonNotLoggedInException("Person not correctly logged in! Try again!");
        }
    }
}
