package com.frightsystem.exceptions;

public class CommandExecutionFailedException extends UsersApplicationException {

    public CommandExecutionFailedException() {}

    public CommandExecutionFailedException(String message) {
        super(message);
    }

    public CommandExecutionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandExecutionFailedException(Throwable cause) {
        super(cause);
    }

    public CommandExecutionFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
