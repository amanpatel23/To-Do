package com.example.aman.to_doapp.models;

import com.example.aman.to_doapp.interfaces.IModel;
import com.example.aman.to_doapp.interfaces.ITodoService;

import java.util.List;
import java.util.UUID;

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
    public void delete(Object todo) {
        todos.remove(todo);
    }

    @Override
    public void close() {

    }

    @Override
    public void add(Object o) {

    }

    @Override
    public void edit(Object o, UUID a) {

    }




}
