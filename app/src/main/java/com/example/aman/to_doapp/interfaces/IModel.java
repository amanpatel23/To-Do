package com.example.aman.to_doapp.interfaces;

import com.example.aman.to_doapp.models.Todo;

import java.util.List;

/**
 * Created by Aman on 2/15/17.
 */

public interface IModel {
    List<Todo> getTodos();

    void delete(int position);

    void add(Todo todo);

    void edit(Todo todo);



}
