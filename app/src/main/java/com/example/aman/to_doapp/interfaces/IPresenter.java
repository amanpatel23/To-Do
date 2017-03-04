package com.example.aman.to_doapp.interfaces;

import com.example.aman.to_doapp.models.Todo;

import java.util.List;


/**
 * Created by Aman on 2/15/17.
 */

public interface IPresenter {


    void handleClick(Todo text, int adapterPosition);

    List<Todo> getTodos();

    void handleLongPress(int position);

    void handleAddClick();

    void handleEditClick(int position);

    //void markCurrentTodoCompleted();


}
