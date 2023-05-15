package com.michael.dev.todolist.dao;

import com.michael.dev.todolist.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoDao extends CrudRepository<Todo,Integer> {
}
