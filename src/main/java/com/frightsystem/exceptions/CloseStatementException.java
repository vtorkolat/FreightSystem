package com.frightsystem.exceptions;

public class CloseStatementException extends RuntimeException {

    public CloseStatementException() {}

    public CloseStatementException(String message) {
        super(message);
    }

    public CloseStatementException(String message, Throwable cause) {
        super(message, cause);
    }
}
