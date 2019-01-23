package com.example.university.se.intservices;

import com.example.university.se.exceptions.PersonNotLoggedInException;
import com.example.university.se.models.PersonModel;

import java.util.Optional;

public interface LoginServiceInterface {
    Optional<PersonModel> getPersonAndVerifyPassword(String username, String password) throws PersonNotLoggedInException;
}
