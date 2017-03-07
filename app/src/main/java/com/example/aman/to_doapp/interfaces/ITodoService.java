package com.example.aman.to_doapp.interfaces;

import com.example.aman.to_doapp.models.Todo;

import java.util.List;


/**
 * Created by Aman on 2/15/17.
 */

public interface ITodoService {
    List<Todo> getTodos();

    void addTodo(Todo todo);
    void UpdateTodo(Todo todo);
}
