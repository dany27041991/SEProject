package com.example.universitySE.intservices;

import com.example.universitySE.exceptions.PersonNotLoggedInException;
import com.example.universitySE.exceptions.ProblemConnectionDbException;
import com.example.universitySE.models.PersonModel;

import java.util.Optional;

public interface LoginServiceInterface {
    Optional<PersonModel> getPersonAndVerifyPassword(String username, String password) throws PersonNotLoggedInException, ProblemConnectionDbException;
}

