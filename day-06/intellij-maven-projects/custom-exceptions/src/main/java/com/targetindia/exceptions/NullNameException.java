package com.targetindia.exceptions;

public class NullNameException extends Exception{
    // by extending Exception class, our class becomes a checked exception.
    // meaning, the compiler CHECKS if the statement throwing this exception object,
    // has been handled or not.
    public NullNameException() {
        super("Name was NULL");
    }

    public NullNameException(String message) {
        super(message);
    }

    public NullNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullNameException(Throwable cause) {
        super(cause);
    }

    public NullNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
