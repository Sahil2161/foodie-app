package com.cgi.foodie.exceptions;

public class UserAlreadyExistsException extends Exception{
    private static final String MESSAGE = "User already exists proceed to login or signup for new user";

    public UserAlreadyExistsException() {
        super(MESSAGE);
    }
}
