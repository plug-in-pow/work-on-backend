package com.workon.todo.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collectionName = "todos")
public class TodoModel {

    @DocumentId
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
}
