package com.example.aman.to_doapp.presenters;

import android.content.Intent;

import com.example.aman.to_doapp.Constants;
import com.example.aman.to_doapp.interfaces.IEditPresenter;
import com.example.aman.to_doapp.interfaces.IModel;
import com.example.aman.to_doapp.interfaces.IEditView;
import com.example.aman.to_doapp.viewmodels.EditTodoViewModel;
import com.example.aman.to_doapp.R;

/**
 * Created by Aman on 2/15/17.
 */

public class EditTodoPresenter implements IEditPresenter {

    IModel model;
    IEditView view;
    EditTodoViewModel viewModel;

    public EditTodoPresenter(IEditView view, IModel model) {
        this.view = view;
        this.model = model;
        this.viewModel = new EditTodoViewModel();
    }

    @Override
    public void showName(int requestCode) {
        if(requestCode == Constants.ADD_TODO_REQUEST_CODE) {
            view.displayName(R.string.add_todo_text);
        } else {
            view.displayName(R.string.edit_todo_text);
        }
    }

    @Override
    public void updateTodoName(String text) {
        viewModel.name = text;
        view.updateViewWithViewModel(viewModel);
    }

    @Override
    public void updateTodoContent(String text) {
        viewModel.content = text;
        view.updateViewWithViewModel(viewModel);
    }

    @Override
    public void updateTodoDateCreated(String text) {
        viewModel.dateCreated = text;
        view.updateViewWithViewModel(viewModel);
    }

    @Override
    public void updateTodoDueDate(String text) {
        viewModel.dueDate = text;
        view.updateViewWithViewModel(viewModel);
    }

    @Override
    public void validateModel() {
        if(viewModel.validate()){
            view.returnResult(viewModel);
        } else {
            view.displayInvalid(viewModel);
        }
    }

    @Override
    public void saveTodo(String name, String content, String dateCreated, String dueDate) {
        Intent intent = new Intent();
        intent.putExtra("NAME", name);
        intent.putExtra("CONTENT", content);
        intent.putExtra("DATE CREATED", dateCreated);
        intent.putExtra("DUE DATE", dueDate);
        view.sendTodoBack(intent);
    }

    @Override
    public void setViewModel(Intent intent) {
        if(intent.getIntExtra("START_REASON", Constants.ADD_TODO_REQUEST_CODE) == Constants.EDIT_TODO_REQUEST_CODE ) {
            viewModel.name = intent.getStringExtra("NAME");
            viewModel.content = intent.getStringExtra("CONTENT");
            viewModel.dateCreated = intent.getStringExtra("DATE CREATED");
            viewModel.dueDate = intent.getStringExtra("DUE DATE");
            view.updateViewWithViewModel(viewModel);
            view.setInitialFields(viewModel);
        }
    }
}
