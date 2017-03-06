package com.example.aman.to_doapp.interfaces;

import android.content.Intent;

/**
 * Created by Aman on 2/15/17.
 */

public interface IEditPresenter {

    void showName(int requestCode);
    void updateTodoName(String text);
    void updateTodoContent(String text);
    void updateTodoDueDate(String text);
    void validateModel();
    void saveTodo(String name, String content, String dueDate);

    void setViewModel(Intent intent);


}
