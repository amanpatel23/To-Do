package com.example.aman.to_doapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aman.to_doapp.R;
import com.example.aman.to_doapp.interfaces.IEditPresenter;
import com.example.aman.to_doapp.interfaces.IEditView;
import com.example.aman.to_doapp.viewmodels.EditTodoViewModel;

/**
 * Created by Aman on 3/8/2017.
 */

public class EditFragment extends Fragment implements IEditView {

    private IEditPresenter presenter;

    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        return view;
    }

    @Override
    public void displayName(int name) {

    }

    @Override
    public void updateViewWithViewModel(EditTodoViewModel vm) {

    }

    @Override
    public void returnResult(EditTodoViewModel viewModel) {

    }

    @Override
    public void displayInvalid(EditTodoViewModel viewModel) {

    }

    @Override
    public void setInitialFields(EditTodoViewModel viewModel) {

    }

    @Override
    public void sendTodoBack(Intent intent) {

    }
}
