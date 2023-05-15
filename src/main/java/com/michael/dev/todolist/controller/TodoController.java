package com.michael.dev.todolist.controller;


import com.michael.dev.todolist.entity.Todo;
import com.michael.dev.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public Iterable<Todo> getTodoList(){
        Iterable<Todo> todoList = todoService.getTodos();
        return todoList;
    }
}
