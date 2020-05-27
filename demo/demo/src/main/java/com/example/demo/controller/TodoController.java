package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public List<Todo> selectAllTodos(){
        return this.todoService.getTodos();
    }

    @PostMapping("/")
    public void addTodo(@RequestBody  Todo todo){
        this.todoService.addTodo(todo.getTitle(), todo.getIsComplete());
    }
    @PatchMapping("/{id}")
    public void patchTodo(@PathVariable("id") UUID id, @RequestBody Todo patch){
        this.todoService.patchTodo(id, patch);
    }
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable("id") UUID id){
        this.todoService.deleteTodo(id);
    }


}
