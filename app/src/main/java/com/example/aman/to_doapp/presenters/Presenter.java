package com.example.aman.to_doapp.presenters;

import com.example.aman.to_doapp.interfaces.IModel;
import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.interfaces.IView;
import com.example.aman.to_doapp.models.Todo;

import java.util.List;
import java.util.UUID;

/**
 * Created by Aman on 2/15/17.
 */

public class Presenter implements IPresenter {

    IModel<Todo> db;
    IView view;

    public Presenter(IView view, IModel<Todo> dataSource) {
        this.view = view;
        this.db = dataSource;
    }

    @Override
    public List<Todo> getTodos() {
        return db.getTodos();
    }

    @Override
    public void handleClick(int adapterPosition) {
        view.showEditView(adapterPosition);
        db.edit(getTodos().get(adapterPosition));
    }

    @Override
    public void handleLongPress(int position) {
        db.delete(getTodos().get(position));
        view.handleDelete(position);
    }

    @Override
    public void handleAddClick() {
        addTodo();
    }

    @Override
    public void addTodo() {
        Todo todo = new Todo("sljs","adkjs","2", false);
        todo.id = UUID.randomUUID();
        db.add(todo);
        view.refreshTodos(db.getTodos());
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
