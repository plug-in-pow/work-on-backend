package com.workon.todo.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.workon.todo.exception.FirestoreDataException;
import com.workon.todo.model.SuccessModel;
import com.workon.todo.model.TodoModel;
import com.workon.todo.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public ResponseEntity<List<TodoModel>> getAllTodo() {
        return new ResponseEntity<List<TodoModel>>(todoRepository.findAll().collectList().block(), HttpStatus.OK) ;
    }

    public ResponseEntity<TodoModel> getTodoById(String docId) {
        if(todoRepository.existsById(docId).block()){
            return new ResponseEntity<TodoModel>(todoRepository.findById(docId).block(), HttpStatus.OK);
        }else{
            throw new FirestoreDataException("Specified Id does not exist");
        }
    }

    public ResponseEntity<SuccessModel> createTodo(TodoModel todo) {
        try{
            todoRepository.save(todo).block();
        }catch(RuntimeException e){
            throw new FirestoreDataException("Unable to save in database");
        }
        SuccessModel successResponse = new SuccessModel();
        successResponse.setMessage("Todo Added Successfully!");
        successResponse.setStatusCode(HttpStatus.CREATED.value());
        successResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<SuccessModel>(successResponse,HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> deleteTodo(String docId) {
        if(todoRepository.existsById(docId).block()){
            try{
                todoRepository.deleteById(docId).block();
            }catch(RuntimeException e){
                throw new FirestoreDataException("Unable to delete");
            }
            SuccessModel successResponse = new SuccessModel();
            successResponse.setMessage("Deleted Successfully!");
            successResponse.setStatusCode(HttpStatus.OK.value());
            successResponse.setTimeStamp(System.currentTimeMillis());
            return new ResponseEntity<SuccessModel>(successResponse,HttpStatus.OK);
        }else{
            throw new FirestoreDataException("Specified Id does not exist");
        }
    }

    public ResponseEntity<SuccessModel> updateTodo(TodoModel todo) {
        if(todoRepository.existsById(todo.getId()).block()){
            try{
                todoRepository.save(todo).block();
            }catch(RuntimeException e){
                throw new FirestoreDataException("Unable to update in database");
            }
            SuccessModel successResponse = new SuccessModel();
            successResponse.setMessage("Todo Updated Successfully!");
            successResponse.setStatusCode(HttpStatus.OK.value());
            successResponse.setTimeStamp(System.currentTimeMillis());
            return new ResponseEntity<SuccessModel>(successResponse,HttpStatus.OK);
        }else{
            throw new FirestoreDataException("Specified Todo does not exist"); 
        }
    }
    
}
