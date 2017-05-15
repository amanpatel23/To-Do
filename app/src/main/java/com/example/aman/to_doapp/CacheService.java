package com.example.aman.to_doapp;

import android.content.Context;

import com.example.aman.to_doapp.models.Todo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class CacheService {
    private static CacheService ourInstance = new CacheService();

    public static CacheService getInstance() {
        return ourInstance;
    }


    private CacheService() {
    }

    public void clearCache(Context ctx) {
        for(File file : ctx.getCacheDir().listFiles()) {
            file.delete();
        }
    }

    public Todo getCachedTodo(Context ctx, final String id) {
        File[] files = ctx.getCacheDir().listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.startsWith(id);
            }
        });
        if(files.length == 0) return null;
        return new Todo();
    }

    public void cacheTodo(Context ctx, String name, String Content, String duedate) {
        try {
            File dir = ctx.getCacheDir();
            File cache = File.createTempFile(name + Content + duedate, String.valueOf(dir));
            FileOutputStream fos = new FileOutputStream(cache);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Todo getCachedFile(Context ctx, String id) {
        return null;
    }
}