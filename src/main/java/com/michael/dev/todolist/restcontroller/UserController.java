package com.michael.dev.todolist.restcontroller;

import com.michael.dev.todolist.entity.User;
import com.michael.dev.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users/{id}/todos")
    public ResponseEntity getTodosByUserId (@PathVariable Integer id) {
        Optional<User> todos = userService.getTodosByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(todos);
    }
}
