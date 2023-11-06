package com.workon.todo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ErrorModel {
    int errorCode;
    String errorDescription;
    long timeStamp;
}
