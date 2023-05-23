package com.targetindia.exceptions;

public class DuplicatePhoneException extends RuntimeException{
    public DuplicatePhoneException() {
        super("Phone already exists");
    }

    public DuplicatePhoneException(String message) {
        super(message);
    }

    public DuplicatePhoneException(Throwable cause) {
        super(cause);
    }
}
