package com.michael.dev.todolist.dao;

import com.michael.dev.todolist.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {
}
