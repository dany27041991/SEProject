package com.example.universitySE.exceptions;

public class PersonNotLoggedInException extends Exception {

    public PersonNotLoggedInException(String erroreMessage) {
        super(erroreMessage);
    }
}

