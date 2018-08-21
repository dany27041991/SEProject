package com.projectSE.credentialMicroservices.exceptions;

public class UserNotLoggedException extends Exception {
    public UserNotLoggedException(String errorMessage){
        super(errorMessage);
    }
}
