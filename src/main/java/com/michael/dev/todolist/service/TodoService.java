package com.michael.dev.todolist.service;

import com.michael.dev.todolist.dao.TodoDao;
import com.michael.dev.todolist.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;

    public Iterable<Todo> getTodos(){
        return todoDao.findAll();
    }

    public Integer createTodoReturnId(Todo todo) {
        Todo rltTodo = todoDao.save(todo);
        return rltTodo.getId();
    }

    public Iterable<Todo> createTodoReturnList(Todo todo) {
        todoDao.save(todo);
        return getTodos();
    }
    public Boolean updateTodo(Integer id,Todo todo) {
        Optional<Todo> isExistTodo = Optional.ofNullable(findById(id));
        if (! isExistTodo.isPresent()) {
            return false;
        }
        Todo newTodo = isExistTodo.get();
        if (todo.getStatus() == null) {
            return false;
        }
        newTodo.setStatus(todo.getStatus());
        todoDao.save(newTodo);
        return true;
    }


    public Todo findById(Integer id) {
        Todo todo = todoDao.findById(id).get();
        return todo;
    }

    public Boolean deleteTodo(Integer id) {
        Optional<Todo> findTodo = Optional.ofNullable(findById(id));
        if (!findTodo.isPresent()) {
            return false;
        }
        todoDao.deleteById(id);
        return true;
    }
}
