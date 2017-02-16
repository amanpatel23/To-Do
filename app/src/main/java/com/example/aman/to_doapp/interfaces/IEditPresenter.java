package com.example.aman.to_doapp.interfaces;

import android.content.Intent;

/**
 * Created by Aman on 2/15/17.
 */

public interface IEditPresenter {

    void showName(int requestCode);
    void updateTodoContent(String text);
    void updateTodoName(String text);
    void validateModel();
    void saveTodo(String name, String content);

    void setViewModel(Intent intent);
}
