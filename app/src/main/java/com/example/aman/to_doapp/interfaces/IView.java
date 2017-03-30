package com.example.aman.to_doapp.interfaces;

import com.example.aman.to_doapp.models.Todo;

import java.util.List;

/**
 * Created by Aman on 2/15/17.
 */

public interface IView {


    void showAddView();

    void showEditView(int position);

    void handleDelete(int position);

    void handleAdd(int i);

    void handleEdit(int position);

    void refreshTodos(List<Todo> all);
}
