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

public class TodoDB implements IModel<Todo> {

    private static final String DB_NAME = "Todo.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Todo";
    private static final String ID = "_id";
    private static final String TODO_NAME = "name";
    private static final String TODO_CONTENT = "content";
    private static final String TODO_DUEDATE = "duedate";
    SQLiteDatabase db;

    public TodoDB(Context context) {
        Helper helper = new Helper(context, DB_NAME, null, DB_VERSION);
        db = helper.getWritableDatabase();
    }


    public void close() {
        db.close();
    }

    private Todo makeTodo(Cursor cursor) {
        Todo todo = new Todo();
        todo.id = UUID.fromString(cursor.getString(cursor.getColumnIndex(ID)));
        todo.setName(cursor.getString(cursor.getColumnIndex(TODO_NAME)));
        todo.setContents(cursor.getString(cursor.getColumnIndex(TODO_CONTENT)));
        todo.setDueDate(cursor.getString(cursor.getColumnIndex(TODO_DUEDATE)));
        return todo;
    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        while(cursor.moveToNext()) {
            Todo todo = makeTodo(cursor);
            todos.add(todo);
        }
        cursor.close();
        return todos;
    }


    @Override
    public void add(Todo person) {
        ContentValues cv = makeCV(person);
        cv.put("_id", person.id.toString());
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void edit(Todo person) {
        ContentValues contentValues = makeCV(person);
        db.update(TABLE_NAME, contentValues, ID + " = ?", new String[]{person.id.toString()});
    }

    private ContentValues makeCV(Todo todos) {
        ContentValues cv = new ContentValues();
        cv.put(TODO_NAME, todos.getName());
        cv.put(TODO_CONTENT, todos.getContents());
        cv.put(TODO_DUEDATE, todos.getDueDate());
        return cv;
    }

    @Override
    public void delete(Todo person) {
        db.delete(TABLE_NAME, ID + " = ?", new String[]{person.id.toString()});
    }

    class Helper extends SQLiteOpenHelper {

        public Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String createStatement = String.format("create table %s "
                            + " (%s text primary key not null," // uuid id
                            + " %s text not null," // name
                            + " %s text not null);" // content
                            + " %s text not null);" // duedate
                    , TABLE_NAME, ID, TODO_NAME, TODO_CONTENT, TODO_DUEDATE);
            sqLiteDatabase.execSQL(createStatement);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}