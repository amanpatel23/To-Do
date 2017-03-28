package com.example.aman.to_doapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aman.to_doapp.interfaces.IModel;
import com.example.aman.to_doapp.models.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Aman on 3/27/17.
 */

public class TodoDB extends SQLiteOpenHelper implements IModel<Todo> {

    private static final String DB_NAME = "Todo.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Todo";
    private static final String COLUMN_ID = "_id";
    private static final String TODO_NAME = "name";
    private static final String TODO_CONTENT = "content";
    private static final String TODO_DUEDATE = "duedate";
    private static final boolean TODO_COMPLETED = false;

    public TodoDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format(
                "Create Table %s "
                + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," // id
                + " %s text not null," // name
                + " %s text not null);" // content
                + " %s text not null);" // duedate
                + " %s text not null);"// completed
                , TABLE_NAME, COLUMN_ID, TODO_NAME, TODO_CONTENT, TODO_DUEDATE, TODO_COMPLETED);

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public List<Todo> getTodos() {
        return null;
    }

    @Override
    public void delete(int position) {

    }

    public void add(Todo todo) {
        ContentValues values = new ContentValues();
        values.put(TODO_NAME, todo.getName());
        values.put(TODO_CONTENT, todo.getContents());
        values.put(TODO_DUEDATE, todo.getDueDate());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void edit(Todo todo) {

    }

    public void delete(Todo todo) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{todo.id.toString()});
    }

    public List<Todo> getAll() {
        SQLiteDatabase db = getWritableDatabase();
        List<Todo> todos = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        while(cursor.moveToNext()) {
            Todo todo = makeTodo(cursor);
            todos.add(todo);
        }
        cursor.close();
        return todos;
    }

    private Todo makeTodo(Cursor cursor) {
        Todo todo = new Todo();
        todo.id = UUID.fromString(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
        todo.setName(cursor.getString(cursor.getColumnIndex(TODO_NAME)));
        todo.setContents(cursor.getString(cursor.getColumnIndex(TODO_CONTENT)));
        todo.setDueDate(cursor.getString(cursor.getColumnIndex(TODO_DUEDATE)));
        return todo;
    }



}
