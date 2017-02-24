package com.example.aman.to_doapp;

import com.example.aman.to_doapp.interfaces.ITodoService;
import com.example.aman.to_doapp.services.TodoService;

/**
 * Created by Aman on 2/15/17.
 */

public class Singleton {

    private static Singleton instance;
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    private ITodoService todoService;
    private Singleton() {
        ITodoService todos = TodoService.gettodoService();
        todoService = todos;
    }

}
