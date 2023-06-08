package com.targetindia.dao;

public class DaoException extends RuntimeException{
    private static final long serialVersionUID = -1045613215680031082L;

	public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
