package com.frightsystem.exceptions;

public class UsersApplicationException extends RuntimeException {

    public UsersApplicationException() {}

    public UsersApplicationException(String message) {
        super(message);
    }

    public UsersApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsersApplicationException(Throwable cause) {
        super(cause);
    }

    public UsersApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
