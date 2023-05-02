package com.targetindia.exceptions;

public class DuplicateEmailException extends RuntimeException{
    public DuplicateEmailException() {
        super("Email already present");
    }

    public DuplicateEmailException(String message) {
        super(message);
    }

    public DuplicateEmailException(Throwable cause) {
        super(cause);
    }
}
