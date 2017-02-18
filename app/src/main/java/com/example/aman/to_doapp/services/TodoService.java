package com.example.aman.to_doapp.services;

import java.util.ArrayList;
import java.util.List;

import com.example.aman.to_doapp.interfaces.ITodoService;
import com.example.aman.to_doapp.models.Todo;

/**
 * Created by Aman on 2/15/17.
 */

public class TodoService implements ITodoService {

    List<Todo> todos;

    public TodoService(){
        todos = new ArrayList<>();
        Todo todo = new Todo("Finish HW", "COSC 431", "2/15/17","2/20/17", false, false);
        todos.add(todo);
        todo = new Todo("Project Due", "COSC 412", "2/15/17","5/20/17", true, true);
        todos.add(todo);
        todo = new Todo("Extra Credit", "COSC 457", "2/12/17","5/16/17", false, false);
        todos.add(todo);

    }

    @Override
    public List<Todo> getTodos() {
        return todos;
    }
}
