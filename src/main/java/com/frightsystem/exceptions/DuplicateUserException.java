package com.frightsystem.exceptions;


public class DuplicateUserException extends Exception {

    public DuplicateUserException()

    {
    }

    public DuplicateUserException(String message) {

    }

    public DuplicateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateUserException(Throwable cause) {
        super(cause);
    }

    public DuplicateUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
