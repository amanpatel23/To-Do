package com.example.aman.to_doapp.models;

import java.util.UUID;

/**
 * Created by Aman on 2/15/17.
 */

public class Todo {

    public UUID id;
    private String name;
    private String contents;
    private String dueDate;
    private boolean isCompleted;


    public Todo() {}


    public Todo(String name, String contents, String dueDate, boolean completed){
        this.name = name;
        this.contents = contents;
        this.dueDate = dueDate;
        this.isCompleted = completed;
    }

    public String toString() {
        return name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }


    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }


    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }


    public boolean isCompleted() { return isCompleted; }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


}