package com.workon.todo.exception;

public class MandatoryFieldMissing extends RuntimeException {
    
    public MandatoryFieldMissing() {
        super();
    }

    public MandatoryFieldMissing(String message) {
        super(message);
    }

    public MandatoryFieldMissing(String message, Throwable cause) {
        super(message,cause);
    }
}
