package com.example.aman.to_doapp;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.example.aman.to_doapp.TodoContract.BASE_CONTENT_URI;
import static com.example.aman.to_doapp.TodoContract.todo.COLUMN_CONTENT;

public class TodoCompanion extends ContentProvider {
    private SQLiteDatabase TodoDB;

    //authority
    public static final String CONTENT_AUTHORITY = "com.example.aman.to_doapp";



    public static final String PATH_NAME = "name";
    private static final String TAG = "TodoProvider";


    public static final Uri CONTENT_URI =
            BASE_CONTENT_URI.buildUpon().appendPath(CONTENT_AUTHORITY).build();


    public static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(TodoContract.CONTENT_AUTHORITY, TodoContract.BASE_CONTENT_URI.getPath(), TodoContract.TASKS_LIST);
        uriMatcher.addURI(TodoContract.CONTENT_AUTHORITY, TodoContract.BASE_CONTENT_URI.getPath() + "/#", TodoContract.TASKS_ITEM);
    }

    @Override
    public boolean onCreate() {
        TodoDB = new TodoDbHelper(getContext()).getWritableDatabase();
        boolean isDbNull = (TodoDB == null);
        Log.i(TAG, "onCreate(): isDbNull: " + isDbNull);
        return (TodoDB != null);
    }


    @Override
    public Cursor query( Uri uri,  String[] projection,  String selection, String[] selectionArgs,  String sortOrder) {
        SQLiteCursor cursor = (SQLiteCursor) TodoDB.query(TodoDbHelper.COLUMN_NAME, projection, selection,
                selectionArgs, null, null, sortOrder);
        return cursor;
    }

    @Nullable
    @Override
    public String getType( Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert( Uri uri,  ContentValues values) {
        long lastRowId = TodoDB.insert(TodoCompanion.TodoDbHelper.COLUMN_NAME, TodoCompanion.TodoDbHelper.COLUMN_NAME, values);
        Uri lastAddedItem = ContentUris.withAppendedId(BASE_CONTENT_URI, lastRowId);
        return lastAddedItem;
    }

    @Override
    public int delete( Uri uri, String selection,  String[] selectionArgs) {
        int numberOfDeletedRows = TodoDB.delete(String.valueOf(TodoDB), selection, selectionArgs);
        return numberOfDeletedRows;
    }

    @Override
    public int update( Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
    protected static class TodoDbHelper extends SQLiteOpenHelper implements BaseColumns {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "TodoDB";
        public static final String TABLE_NAME = "TODOS";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "name";;

        public TodoDbHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_CONTENT +" TEXT " +
                    ");";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

    }
}
