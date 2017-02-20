package com.example.aman.to_doapp.presenters;

import java.util.List;

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
    int currentTodoIndex;

    public Presenter(IView view, IModel model) {
        this.model = model;
        this.view = view;
        currentTodoIndex = 0;
        view.displayTodo(getCurrentTodo());
    }

    @Override
    public void moveToPrevTodo() {
        List<Todo> todos = model.getTodos();
        currentTodoIndex--;
        if(currentTodoIndex < 0) {
            currentTodoIndex = todos.size() - 1;
        }
        view.displayTodo(getCurrentTodo());
    }

    @Override
    public void moveToNextTodo() {
        List<Todo> todos = model.getTodos();
        currentTodoIndex++;
        if(currentTodoIndex >= todos.size()) {
            currentTodoIndex = 0;
        }
        view.displayTodo(getCurrentTodo());
    }

    @Override
    public Todo getCurrentTodo() {
        List<Todo> Todos = model.getTodos();
        if(Todos.size() == 0) {
            return null;
        }
        return Todos.get(currentTodoIndex);
    }

    @Override
    public void markCurrentTodoImportant() {
        Todo todo = getCurrentTodo();
        todo.setImportant(!todo.isImportant());
        view.displayTodo(todo);
    }

    @Override
    public void markCurrentTodoCompleted() {
        Todo todo = getCurrentTodo();
        todo.setCompleted(!todo.isImportant());
        view.displayTodo(todo);
    }

    @Override
    public Todo getNextTodo() {
        return model.getTodos().get(currentTodoIndex+1);
    }

    @Override
    public void showAddOrEditView(Todo todo) {
        if(todo == null) {
            view.showAddView();
        } else {
            view.showEditView();
        }
    }

    @Override
    public void handleNextBtnClick() {

    }

    @Override
    public void handlePrevBtnClick() {

    }

}
