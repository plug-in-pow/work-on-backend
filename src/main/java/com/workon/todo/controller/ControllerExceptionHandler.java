package com.workon.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.workon.todo.exception.FirestoreDataException;
import com.workon.todo.exception.IncorrectPayloadException;
import com.workon.todo.model.ErrorModel;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(IncorrectPayloadException.class)
    public ResponseEntity<ErrorModel> handleIncorrectPayloadException(IncorrectPayloadException exception) {
        ErrorModel error = new ErrorModel();
        error.setErrorDescription(exception.getMessage());
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorModel>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FirestoreDataException.class)
    public ResponseEntity<ErrorModel> handleFirestoreStoreException(FirestoreDataException exception) {
        ErrorModel error = new ErrorModel();
        error.setErrorDescription(exception.getMessage());
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorModel>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
