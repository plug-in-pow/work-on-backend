package com.workon.todo.exception;

public class FirestoreDataException extends RuntimeException {
    
    public FirestoreDataException() {
        super();
    }

    public FirestoreDataException(String message) {
        super(message);
    }

    public FirestoreDataException(String message, Throwable cause) {
        super(message,cause);
    }

}
