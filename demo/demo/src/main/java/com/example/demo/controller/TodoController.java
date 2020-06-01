package com.example.demo.controller;

import com.example.demo.exceptions.TodoInvalidException;
import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo){
        Todo newtodo =  this.todoService.addTodo(todo.getTitle(), todo.getIsComplete());
        if(newtodo == null){
            throw new TodoInvalidException();
        }
        return new ResponseEntity<Todo>(newtodo, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Todo> patchTodo(@PathVariable("id") UUID id, @RequestBody Todo patch ){
        Todo updateTodo = this.todoService.patchTodo(id,patch);
        if(updateTodo == null){
            throw new TodoInvalidException();
        }
        return new ResponseEntity<Todo>(updateTodo, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable("id") UUID id){
        this.todoService.deleteTodo(id);
    }


}
