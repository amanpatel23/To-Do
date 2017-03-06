package com.example.aman.to_doapp.models;

import com.example.aman.to_doapp.interfaces.IModel;
import com.example.aman.to_doapp.interfaces.ITodoService;

import java.util.List;

/**
 * Created by Aman on 2/15/17.
 */

public class TodosModel implements IModel {


    List<Todo> todos;

    public TodosModel(ITodoService todoService) {
        todos = todoService.getTodos();
    }

    @Override
    public List<Todo> getTodos() {
        return todos;
    }

    @Override
    public void delete(int position) {
        todos.remove(position);
    }

    @Override
    public void add(Todo todo) {
        todos.add(0, todo);
    }

    @Override
    public void edit(Todo todo) {

    }



}
