package com.targetindia.repository;

public class RepositoryException extends RuntimeException {
    public RepositoryException() {
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }
}
