package com.workon.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workon.todo.model.TodoModel;
import com.workon.todo.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoModel> getAllTodo() {
        return null;
    }

    public String createTodo(TodoModel todo) {
        return null;
    }

    public String deleteTodo(String docId) {
        return null;
    }

    public String updateTodo(TodoModel todo) {
        return null;
    }
    
}
