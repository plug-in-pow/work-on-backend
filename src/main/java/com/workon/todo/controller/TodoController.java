package com.workon.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workon.todo.model.TodoModel;
import com.workon.todo.services.TodoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;
    
    @GetMapping
    public List<TodoModel> getTodo() {
        return todoService.getAllTodo();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<TodoModel> addTodo(@RequestBody TodoModel todo){
        todoService.createTodo(todo);
        return new ResponseEntity<>(todo,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public String updateTodo(@Valid @RequestBody TodoModel todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/delete/{id}")
    public String removeTodo(@PathVariable("id") String docId){
        return todoService.deleteTodo(docId);
    }
}
