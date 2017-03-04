package com.example.aman.to_doapp.presenters;

import android.content.Intent;

import java.util.List;

import com.example.aman.to_doapp.Constants;
import com.example.aman.to_doapp.EditTodoActivity;
import com.example.aman.to_doapp.MainActivity;
import com.example.aman.to_doapp.interfaces.IEditView;
import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.interfaces.IModel;
import com.example.aman.to_doapp.interfaces.IView;
import com.example.aman.to_doapp.models.Todo;

/**
 * Created by Aman on 2/15/17.
 */

public class Presenter implements IPresenter {

    IModel model;
    IView view;

    public Presenter(IView view, IModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void handleClick(Todo text, int adapterPosition) {

    }

    @Override
    public List<Todo> getTodos() {
        return model.getTodos();
    }

    @Override
    public void handleLongPress(int position) {
        model.delete(position);
        view.handleDelete(position);
    }

    @Override
    public void handleAddClick() {
        view.showAddView();
        model.add(new Todo());

    }

    @Override
    public void handleEditClick(int position) {
        view.showEditView(position);
        model.edit(getTodos().get(position));
    }
/*
    @Override
    public void markCurrentTodoCompleted() {
        Todo todo = getTodos();
        todo.setCompleted(!todo.isImportant());
        view.displayTodo(todo);
    }


    @Override
    public void showAddOrEditView(Todo todo) {
        if(todo == null) {
            view.showAddView();
        } else {
            view.showEditView();
        }
    }
*/



}
