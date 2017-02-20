package com.example.aman.to_doapp.Mocks;

import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.models.Todo;

/**
 * Created by Aman on 2/20/17.
 */

public class MockPresenter implements IPresenter {
    @Override
    public void moveToPrevTodo() {

    }

    @Override
    public void moveToNextTodo() {

    }

    @Override
    public Todo getCurrentTodo() {
        return null;
    }

    @Override
    public void markCurrentTodoImportant() {

    }

    @Override
    public void markCurrentTodoCompleted() {

    }

    @Override
    public Todo getNextTodo() {
        return null;
    }

    @Override
    public void showAddOrEditView(Todo todo) {

    }

    @Override
    public void handleNextBtnClick() {

    }

    @Override
    public void handlePrevBtnClick() {

    }
}
