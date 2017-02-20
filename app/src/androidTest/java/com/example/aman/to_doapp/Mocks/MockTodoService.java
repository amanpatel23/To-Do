package com.example.aman.to_doapp.Mocks;

import com.example.aman.to_doapp.interfaces.ITodoService;
import com.example.aman.to_doapp.models.Todo;

import java.util.List;

/**
 * Created by Aman on 2/20/17.
 */
public class MockTodoService implements ITodoService {

    public List<Todo> todos;

    public MockTodoService(List<Todo> todos) { this.todos = todos;}

    @Override
    public List<Todo> getTodos() {
        return null;
    }
}
