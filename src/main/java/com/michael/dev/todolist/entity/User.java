package com.michael.dev.todolist.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    public String name;

    @Column(insertable = false, columnDefinition = "int default 1")
    Integer gender = 1;

    @Column
    public String password;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @EqualsAndHashCode.Exclude
    private Set<Todo> todos;
}
