package com.example.aman.to_doapp.interfaces;

import com.example.aman.to_doapp.models.Todo;

import java.util.List;


/**
 * Created by Aman on 2/15/17.
 */

public interface IPresenter {

    List<Todo> getTodos();

    void handleClick(int adapterPosition);

    void handleLongPress(int position);

    void handleAddClick();

    void addTodo();

    void finish();

    void removeTodo(Todo todo);


    //void markCurrentTodoCompleted();


}
