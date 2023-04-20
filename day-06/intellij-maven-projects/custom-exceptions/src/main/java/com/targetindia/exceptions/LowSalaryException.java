package com.targetindia.exceptions;

public class LowSalaryException extends RuntimeException{
    public LowSalaryException() {
        super("Salary was very low");
    }

    public LowSalaryException(String message) {
        super(message);
    }

    public LowSalaryException(String message, Throwable cause) {
        super(message, cause);
    }

    public LowSalaryException(Throwable cause) {
        super(cause);
    }

    public LowSalaryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
