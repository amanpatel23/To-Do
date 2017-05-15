package com.example.aman.to_doapp.Mocks;

import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.models.Todo;

import java.util.List;

/**
 * Created by Aman on 2/20/17.
 */

public class MockPresenter implements IPresenter {


    @Override
    public List<Todo> getTodos() {
        return null;
    }

    @Override
    public void handleClick(int adapterPosition) {

    }

    @Override
    public void handleLongPress(int position) {

    }

    @Override
    public void handleAddClick() {

    }

    @Override
    public void addTodo() {

    }

    @Override
    public void finish() {

    }

    @Override
    public void removeTodo(Todo todo) {

    }
}
