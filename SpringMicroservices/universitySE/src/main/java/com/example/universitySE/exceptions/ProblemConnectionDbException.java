package com.example.universitySE.exceptions;

public class ProblemConnectionDbException extends Exception{
    public ProblemConnectionDbException() {
        super("Problem Connection to Database. Try later!");
    }
}
