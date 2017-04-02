package com.example.aman.to_doapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;

import com.example.aman.to_doapp.adapters.RecyclerAdapter;
import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.interfaces.ITodoService;
import com.example.aman.to_doapp.interfaces.IView;
import com.example.aman.to_doapp.models.Todo;
import com.example.aman.to_doapp.presenters.Presenter;
import com.example.aman.to_doapp.services.TodoService;

import java.util.List;


public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener,  CompoundButton.OnCheckedChangeListener{

    IPresenter presenter;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addTodo();
            }
        });

        //ITodoService todoService = TodoService.gettodoService();
        presenter = new Presenter(this, new TodoDB(this));
        adapter = new RecyclerAdapter(presenter);

        adapter.notifyDataSetChanged();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
    protected void onStop() {
        super.onStop();
        presenter.finish();
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
        adapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(presenter.getTodos().size()-1);
    }

    @Override
    public void handleEdit(int position) {
        adapter.notifyItemChanged(position);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void refreshTodos(List<Todo> all) {
        if(all != null) {
            // replace the existing list
            adapter.setTodos(all);
        } else {
            // just tell the adapter that something has changed
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_todo_button:
                presenter.addTodo();
                break;
        }
    }

    @Override
    public void handleDelete(int position) {
        adapter.notifyItemRemoved(position);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK) {

                String nameAdd = data.getStringExtra("NAMEI");
                String contentAdd = data.getStringExtra("CONTENTI");
                String duedateAdd = data.getStringExtra("DUE DATEI");
                Todo todo = new Todo(nameAdd,contentAdd,duedateAdd);
                ITodoService todoService = TodoService.gettodoService();
                todoService.addTodo(todo);
                handleAdd(0);
        }

        if(requestCode == 2 && resultCode == RESULT_OK) {

            String nameEdit = data.getStringExtra("NAMEI");
            String contentEdit = data.getStringExtra("CONTENTI");
            String duedateEdit = data.getStringExtra("DUE DATEI");
            SharedPreferences bb = getSharedPreferences("my_prefs", 0);
            int pos = bb.getInt("POS", 0);
            Todo todo = new Todo(nameEdit,contentEdit,duedateEdit);
            ITodoService todoService = TodoService.gettodoService();
            todoService.UpdateTodo(todo, pos);
            handleEdit(pos);
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

}