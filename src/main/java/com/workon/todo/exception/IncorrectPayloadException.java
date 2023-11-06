package com.workon.todo.exception;

public class IncorrectPayloadException extends RuntimeException {
    
    public IncorrectPayloadException() {
        super();
    }

    public IncorrectPayloadException(String message) {
        super(message);
    }

    public IncorrectPayloadException(String message, Throwable cause) {
        super(message,cause);
    }
}
