package com.example.aman.to_doapp.interfaces;

import android.content.Intent;

import com.example.aman.to_doapp.viewmodels.EditTodoViewModel;

/**
 * Created by Aman on 2/15/17.
 */

public interface IEditView {
    void displayName(int name);
    void updateViewWithViewModel(EditTodoViewModel vm);


    void returnResult(EditTodoViewModel viewModel);

    void displayInvalid(EditTodoViewModel viewModel);

    void setInitialFields(EditTodoViewModel viewModel);

    void sendTodoBack(Intent intent);


}