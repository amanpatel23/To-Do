package com.example.aman.to_doapp.Mocks;

import com.example.aman.to_doapp.models.Todo;

/**
 * Created by Aman on 2/20/17.
 */
public class MockView implements com.example.aman.to_doapp.interfaces.IView {

    public boolean displayTodoWasCalled;
    public boolean displayedNextTodo;
    public Todo displayedTodo;


    @Override
    public void showAddView() {

    }

    @Override
    public void showEditView(int position) {

    }

    @Override
    public void handleDelete(int position) {

    }

    @Override
    public void handleAdd(int i) {

    }

    @Override
    public void handleEdit(int position) {

    }
}
