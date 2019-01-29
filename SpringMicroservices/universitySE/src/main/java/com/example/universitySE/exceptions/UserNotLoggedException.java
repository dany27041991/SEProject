package com.example.universitySE.exceptions;

public class UserNotLoggedException extends Exception {
    public UserNotLoggedException(String errorMessage){
        super(errorMessage);
    }
}