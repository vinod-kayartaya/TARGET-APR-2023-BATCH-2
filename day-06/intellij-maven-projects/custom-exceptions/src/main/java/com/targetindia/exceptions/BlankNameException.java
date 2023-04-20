package com.targetindia.exceptions;

public class BlankNameException extends Exception{
    // by extending Exception class, our class becomes a checked exception.
    // meaning, the compiler CHECKS if the statement throwing this exception object,
    // has been handled or not.
    public BlankNameException() {
        super("Name was blank!");
    }

    public BlankNameException(String message) {
        super(message);
    }

    public BlankNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlankNameException(Throwable cause) {
        super(cause);
    }

    public BlankNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
