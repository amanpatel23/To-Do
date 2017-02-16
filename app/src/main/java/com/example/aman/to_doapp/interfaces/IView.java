package com.example.aman.to_doapp.interfaces;

import com.example.aman.to_doapp.models.Todo;


/**
 * Created by Aman on 2/15/17.
 */

public interface IView {

    void displayTodo(Todo todo);

    void displayNextTodo(Todo todo);

    void showAddView();

    void showEditView();
}
