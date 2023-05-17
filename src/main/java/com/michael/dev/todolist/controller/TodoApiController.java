package com.michael.dev.todolist.controller;

import com.michael.dev.todolist.entity.Todo;
import com.michael.dev.todolist.service.TodoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TodoApiController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity getTodos(){
        Iterable<Todo> todoList = todoService.getTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todoList);
    }

    @GetMapping("/todos/{id}")
    public Optional<Todo> getTodo(@PathVariable Integer id){
        Optional<Todo> todo = Optional.ofNullable(todoService.findById(id));
        return todo;
    }

    @PostMapping("/todos")
    public ResponseEntity createTodo(@RequestBody Todo todo){
        Integer rlt = todoService.createTodoReturnId(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(rlt);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity updateTodo(@PathVariable Integer id, @RequestBody Todo todo){
        Boolean rlt = todoService.updateTodo(id,todo);
        if(!rlt){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status can not be null.");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body("");
        }
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity deleteTodo(@PathVariable Integer id){
        Boolean rlt = todoService.deleteTodo(id);
        if(!rlt){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID not exist.");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body("");
        }
    }
}