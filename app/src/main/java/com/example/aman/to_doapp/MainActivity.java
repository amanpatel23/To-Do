package com.example.aman.to_doapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;

import com.example.aman.to_doapp.interfaces.IView;
import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.models.Todo;
import com.example.aman.to_doapp.models.TodosModel;
import com.example.aman.to_doapp.presenters.Presenter;
import com.example.aman.to_doapp.services.TodoService;


public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    IPresenter presenter;

    // widgets
    Button prevBtn;
    Button nextBtn;
    TextView todoNameTv;
    TextView todoContentTv;
    TextView nextTodoTv;
    TextView todoDateCreated;
    TextView todoDueDate;
    LinearLayout todoLayout;
    Button addTodoBtn;
    Button editTodoBtn;
    CheckBox completedCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_pager);
        bindView();
        presenter = new Presenter(this, new TodosModel(new TodoService()));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    private void bindView() {
        todoNameTv = (TextView) findViewById(R.id.todoName);
        todoContentTv = (TextView) findViewById(R.id.todoContent);
        todoDateCreated = (TextView) findViewById(R.id.date_added);
        todoDueDate = (TextView) findViewById(R.id.due_date);
        prevBtn = (Button) findViewById(R.id.prevBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        todoLayout = (LinearLayout)findViewById(R.id.todo_linear_layout);
        addTodoBtn = (Button)findViewById(R.id.add_todo_button);
        editTodoBtn = (Button) findViewById(R.id.edit_todo_button);
        completedCheckBox = (CheckBox) findViewById(R.id.completed_checkBox);

        prevBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        addTodoBtn.setOnClickListener(this);
        editTodoBtn.setOnClickListener(this);
        todoLayout.setOnClickListener(this);
        completedCheckBox.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.prevBtn:
                presenter.moveToPrevTodo();
                break;
            case R.id.nextBtn:
                presenter.moveToNextTodo();
                break;
            case R.id.todo_linear_layout:
                presenter.markCurrentTodoImportant();
                break;
            case R.id.completed_checkBox:
                presenter.markCurrentTodoCompleted();
                break;
            case R.id.add_todo_button:
                presenter.showAddOrEditView(null);
                break;
            case R.id.edit_todo_button:
                presenter.showAddOrEditView(presenter.getCurrentTodo());
        }
    }

    @Override
    public void displayTodo(Todo todo) {
        if(todo == null) {
            todoNameTv.setText(R.string.not_available_text);
            return;
        }
        if(todo.isImportant()) {
            todoNameTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.important_text_size));
        }
        else {
            todoNameTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.normal_text_size));
        }


        if(todo.isCompleted()) {
            completedCheckBox.setChecked(true);
        }
        else {
            completedCheckBox.setChecked(false);
        }

        if(completedCheckBox.isChecked() && todo.isCompleted() == false) {
            completedCheckBox.setChecked(false);
        }
        if(completedCheckBox.isChecked() == false && todo.isCompleted()) {
            completedCheckBox.setChecked(true);
        }

        todoNameTv.setText(todo.getName());
        todoContentTv.setText(todo.getContents());
        todoDateCreated.setText(todo.getDateCreated());
        todoDueDate.setText(todo.getDueDate());
    }

    @Override
    public void displayNextTodo(Todo todo) {
        nextTodoTv.setText(todo.getName());
    }

    @Override
    public void showAddView() {
        Intent intent = EditTodoActivity.newIntent(this);
        intent.putExtra("START_REASON", Constants.ADD_TODO_REQUEST_CODE);
        startActivityForResult(intent, Constants.ADD_TODO_REQUEST_CODE);
    }

    @Override
    public void showEditView() {
        Intent intent = EditTodoActivity.newIntent(this);
        intent.putExtra("NAME", presenter.getCurrentTodo().getName());
        intent.putExtra("CONTENT", presenter.getCurrentTodo().getContents());
        intent.putExtra("START_REASON", Constants.EDIT_TODO_REQUEST_CODE);
        startActivityForResult(intent, Constants.EDIT_TODO_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            Log.d(TAG, data.getStringExtra("NAME") + " " + data.getStringExtra("CONTENT"));
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
