package com.michael.dev.todolist.service;

import com.michael.dev.todolist.dao.TodoDao;
import com.michael.dev.todolist.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;

    public Iterable<Todo> getTodos(){
        return todoDao.findAll();
    }
}
