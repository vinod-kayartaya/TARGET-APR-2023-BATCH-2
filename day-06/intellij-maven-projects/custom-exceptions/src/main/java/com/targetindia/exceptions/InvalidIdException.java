package com.targetindia.exceptions;

public class InvalidIdException extends RuntimeException {
    // by extending the RuntimeException, our class is also an unchecked exception.
    // meaning, compiler does not detect/check if the call to a method throwing this exception
    // is handled or not.

    public InvalidIdException() {
        super("Invalid id supplied");
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(Throwable cause) {
        super(cause);
    }
}
