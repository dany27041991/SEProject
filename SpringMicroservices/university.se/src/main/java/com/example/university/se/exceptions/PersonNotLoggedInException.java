package com.example.university.se.exceptions;

public class PersonNotLoggedInException extends Exception {

    public PersonNotLoggedInException(String erroreMessage) {
        super(erroreMessage);
    }
}
