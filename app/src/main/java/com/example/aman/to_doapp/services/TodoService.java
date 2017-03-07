package com.example.aman.to_doapp.services;

import com.example.aman.to_doapp.interfaces.ITodoService;
import com.example.aman.to_doapp.models.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman on 2/15/17.
 */

public class TodoService implements ITodoService {

    List<Todo> todos;

    private static TodoService todoService = new TodoService();

    public static ITodoService gettodoService() {
        return todoService;
    }

    private TodoService(){
        todos = new ArrayList<>();

        Todo todo = new Todo("Finish HW", "COSC 431","2/20/17", false);
        todos.add(todo);
        todo = new Todo("Project Due", "COSC 412","5/20/17", true);
        todos.add(todo);
        todo = new Todo("Extra Credit", "COSC 457", "5/16/17", false);
        todos.add(todo);
        todo = new Todo("Project Due", "COSC 412","5/20/17", true);
        todos.add(todo);
        todo = new Todo("Dummy 1", "COSC 457", "5/16/17", false);
        todos.add(todo);
        todo = new Todo("Dummy 2", "COSC 412","5/20/17", true);
        todos.add(todo);
        todo = new Todo("Dummy 3", "COSC 457", "5/16/17", false);
        todos.add(todo);
        todo = new Todo("Dummy 4", "COSC 412","5/20/17", true);
        todos.add(todo);
        todo = new Todo("Dummy 5", "COSC 457", "5/16/17", false);
        todos.add(todo);
        todo = new Todo("Dummy 6", "COSC 412","5/20/17", true);
        todos.add(todo);
        todo = new Todo("Dummy 7", "COSC 457", "5/16/17", false);
        todos.add(todo);
    }

    @Override
    public List<Todo> getTodos() {
        return todos;
    }

    @Override
    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    @Override
    public void UpdateTodo(Todo todo) {

    }
}
