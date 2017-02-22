package com.example.aman.to_doapp.interfaces;

import com.example.aman.to_doapp.models.Todo;


/**
 * Created by Aman on 2/15/17.
 */

public interface IPresenter {

    void moveToPrevTodo();
    void moveToNextTodo();
    Todo getCurrentTodo();
    void markCurrentTodoImportant();
    void markCurrentTodoCompleted();
    Todo getNextTodo();

    void showAddOrEditView(Todo todo);

    void handleNextBtnClick();
    void handlePrevBtnClick();
}
