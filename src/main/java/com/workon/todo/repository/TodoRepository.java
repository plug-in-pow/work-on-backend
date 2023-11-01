package com.workon.todo.repository;

import org.springframework.stereotype.Repository;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import com.workon.todo.model.TodoModel;

@Repository
public interface TodoRepository extends FirestoreReactiveRepository<TodoModel> {
}
