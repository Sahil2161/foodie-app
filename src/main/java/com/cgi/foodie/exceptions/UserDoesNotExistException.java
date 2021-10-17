package com.cgi.foodie.exceptions;

public class UserDoesNotExistException extends Exception {
    private static final String MESSAGE = "User does not exist, check your credentials or proceed to signup";

    public UserDoesNotExistException() {
        super(MESSAGE);
    }
}
