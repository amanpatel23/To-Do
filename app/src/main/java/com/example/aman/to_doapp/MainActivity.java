package com.example.aman.to_doapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.content.Intent;

import com.example.aman.to_doapp.adapters.RecyclerAdapter;
import com.example.aman.to_doapp.interfaces.ITodoService;
import com.example.aman.to_doapp.interfaces.IView;
import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.models.TodosModel;
import com.example.aman.to_doapp.presenters.Presenter;
import com.example.aman.to_doapp.services.TodoService;


public class MainActivity extends AppCompatActivity implements IView,  CompoundButton.OnCheckedChangeListener{


    IPresenter presenter;

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.handleAddClick();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ITodoService todoService = TodoService.gettodoService();
        presenter = new Presenter(this, new TodosModel(todoService));
        adapter = new RecyclerAdapter(presenter);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    public void setPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void showAddView() {
        Intent intent = EditTodoActivity.newIntent(this);
        intent.putExtra("START_REASON", Constants.ADD_TODO_REQUEST_CODE);
        startActivityForResult(intent, Constants.ADD_TODO_REQUEST_CODE);
    }

    @Override
    public void showEditView(int position) {
        Intent intent = EditTodoActivity.newIntent(this);
        intent.putExtra("NAME", presenter.getTodos().get(position).getName());
        intent.putExtra("CONTENT", presenter.getTodos().get(position).getContents());
        intent.putExtra("DUE DATE", presenter.getTodos().get(position).getDueDate());
        intent.putExtra("START_REASON", Constants.EDIT_TODO_REQUEST_CODE);
        startActivityForResult(intent, Constants.EDIT_TODO_REQUEST_CODE);
    }


    @Override
    public void handleAdd(int i) {
        adapter.notifyItemInserted(i);
        recyclerView.scrollToPosition(0);
    }

    @Override
    public void handleEdit(int position) {
        adapter.notifyItemChanged(position);
    }

    @Override
    public void handleDelete(int position) {
        adapter.notifyItemRemoved(position);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}