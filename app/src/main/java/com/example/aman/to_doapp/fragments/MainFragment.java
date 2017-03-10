package com.example.aman.to_doapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aman.to_doapp.R;
import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.interfaces.IView;

/**
 * Created by Aman on 3/8/2017.
 */

public class MainFragment extends Fragment implements IView, View.OnClickListener {

    private IPresenter presenter;
    public static final int REQUEST = 1;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        if(presenter != null)
            presenter.getTodos();
        return view;
    }


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

    @Override
    public void onClick(View v) {

    }
}
