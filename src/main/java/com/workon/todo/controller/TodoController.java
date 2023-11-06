package com.workon.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workon.todo.exception.IncorrectPayloadException;
import com.workon.todo.model.SuccessModel;
import com.workon.todo.model.TodoModel;
import com.workon.todo.services.TodoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;
    
    @GetMapping
    public ResponseEntity<List<TodoModel>> getTodo() {
        return todoService.getAllTodo();
    }

    @GetMapping("/data")
    public ResponseEntity<TodoModel> getTodoById(@RequestParam(value = "id", required = true) String docId) {
        return todoService.getTodoById(docId);
    }

    @PostMapping("/add")
    public ResponseEntity<SuccessModel> addTodo(@RequestBody(required = true) @Valid TodoModel todo, Errors error){
        if(error.hasErrors()){
            throw new IncorrectPayloadException("Invalid Payload");
        }
        return todoService.createTodo(todo);
    }

    @PutMapping("/update")
    public ResponseEntity<SuccessModel> updateTodo(@Valid @RequestBody TodoModel todo, Errors error){
        if(error.hasErrors()){
            throw new IncorrectPayloadException("Invalid Payload");
        }
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuccessModel> removeTodo(@PathVariable("id") String docId){
        return todoService.deleteTodo(docId);
    }
}
