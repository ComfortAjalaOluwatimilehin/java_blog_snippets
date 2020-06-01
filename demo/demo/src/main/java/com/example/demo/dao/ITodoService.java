package com.example.demo.dao;

import com.example.demo.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITodoService {
     public Todo addTodo(String title, boolean isCompleted);
     public Todo patchTodo(UUID id, Todo patch);
     public int deleteTodo(UUID id);
     public List<Todo> getTodos();
     public Todo selectTodo(UUID id);

}
