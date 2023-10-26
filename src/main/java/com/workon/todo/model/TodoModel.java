package com.workon.todo.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoModel {

    private String id;

    @NotEmpty
    private String title;
    
    private String description;

    @NotEmpty
    private String lastupdated;

    @NotEmpty
    private String startDate;

    @NotEmpty
    private String endDate;

    @NotEmpty
    private String status;

    public TodoModel() {
        this.id = UUID.randomUUID().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.lastupdated = formatter.format(new Date());
    }
}
