package com.example.aman.to_doapp;

import android.content.ContentResolver;
import android.net.Uri;

import static android.provider.Settings.NameValueTable.NAME;

public  final class TodoContract {
    public static final int DATABASE_VERSION = 1;
    public static final String CONTENT_AUTHORITY = "com.example.aman.to-do";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final int TASKS_LIST = 1;
    public static final int TASKS_ITEM = 2;
    //Possible paths so we can append to the base content URI
    public static final String PATH_NAME = "name";
    public static final String PATH_CONTENT = "content";
    public static final String PATH_DUEDATE = "duedate";


    public static final class todo{
        public static final String TABLE_TODOS = "TODOS";
        public static final String TABLE_NAME ="name";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_DUEDATE = "duedate";


        public static final String PATH_TODO = "todo";
        public static final String PATH_CONTENT = "content";


        public static final Uri NAME_CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_NAME).build();
        public static final Uri CONTENT_CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_CONTENT).build();
        public static final Uri DUEDATE_CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_DUEDATE).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY;

        public static final String[] PROJECTION_ALL =
                {TABLE_NAME, COLUMN_ID, COLUMN_CONTENT, COLUMN_DUEDATE};

        public static final String SORT_ORDER_DEFAULT =
                NAME + " DESC";

    }

}