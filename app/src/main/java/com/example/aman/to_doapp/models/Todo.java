package com.example.aman.to_doapp.models;

/**
 * Created by Aman on 2/15/17.
 */

public class Todo {

    private String name;
    private String contents;
    private String dateCreated;
    private String dueDate;
    private boolean isCompleted;
    private boolean isImportant;

    public Todo() {}
    public Todo(String name, String contents, String dateCreated, String dueDate, boolean completed, boolean important){
        this.name = name;
        this.contents = contents;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
        this.isCompleted = completed;
        this.isImportant = important;
    }

    public String toString() {
        return name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }


    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
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


    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) { isImportant = important; }



}