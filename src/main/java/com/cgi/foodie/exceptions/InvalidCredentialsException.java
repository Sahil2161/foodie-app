package com.cgi.foodie.exceptions;

public class InvalidCredentialsException extends Exception {
    private static final String MESSAGE = "Invalid email or password";

    public InvalidCredentialsException() {
        super(MESSAGE);
    }

}
