package com.example.demo.service;

import com.example.demo.dao.ITodoService;
import com.example.demo.model.Todo;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class TodoService implements ITodoService {
    private List<Todo> todos = new ArrayList<>();

    @Override
    public Todo addTodo(@JsonProperty("title") String title, @JsonProperty("isCompleted") boolean isCompleted) {
        if(Todo.validateTodo(title) == false){
            return null;
        }
        Todo todo = new Todo(UUID.randomUUID(), title, isCompleted);
        todos.add(todo);
        return todo;
    }

    @Override
    public Todo patchTodo(UUID id, Todo patch) {
        if(Todo.validateTodo(patch.getTitle()) == false){
            return null;
        }
        Todo update = new Todo(id, patch.getTitle(), patch.getIsComplete());
        List<Todo> newtodos = this.todos.stream().map(todo -> todo.getId().equals(id)? update : todo).collect(Collectors.toList());
        this.todos = newtodos;
        return patch;
    }

    @Override
    public int deleteTodo(UUID id) {
        List<Todo> newtodos = this.todos.stream().filter(todo -> !todo.getId().equals(id)).collect(Collectors.toList());
        this.todos = newtodos;
        return 0;
    }

    @Override
    public List<Todo> getTodos() {
        return this.todos;
    }

    @Override
    public Todo selectTodo(UUID id) {
       Todo match =  todos.stream().filter(todo -> todo.getId().equals(id)).findFirst().orElse(null);
       return match;
    }
}
