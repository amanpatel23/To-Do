package com.example.aman.to_doapp.models;

import com.example.aman.to_doapp.interfaces.IModel;
import com.example.aman.to_doapp.interfaces.ITodoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman on 2/15/17.
 */

public class TodosModel implements IModel {

    List<Todo> todos;

    public TodosModel(ITodoService todoService) {
        todos = new ArrayList<>();
        todos.add(new Todo());
        todos = todoService.getTodos();
    }

    @Override
    public List<Todo> getTodos() {
        return todos;
    }


}
