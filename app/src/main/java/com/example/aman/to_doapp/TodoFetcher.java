package com.example.aman.to_doapp;

import android.content.Context;
import com.example.aman.to_doapp.models.Todo;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class TodoFetcher {

    public interface Callback {
        void onSuccess(Context todo, String id);
        void onError(String src);
    }
    private Context ctx;
    public TodoFetcher(Context ctx) {
        this.ctx = ctx;
    }

    static ThreadPoolExecutor executor =
            (ThreadPoolExecutor)Executors.newFixedThreadPool(2);

    public static void fetch(final Context ctx, final String id, final Callback cb) {
        final Todo todo = CacheService.getInstance().getCachedFile(ctx, id);
        if(todo != null) {
            cb.onSuccess(ctx, id);
        } else {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        if(todo == null) {
                            cb.onError("Todo not found");
                            return;
                        }
                        CacheService.getInstance().cacheTodo(ctx, todo.name, todo.contents,todo.dueDate);
                        cb.onSuccess(ctx, id);
                    } catch (Exception e) {
                        cb.onError("Oops");
                    }
                }
            });
        }
    }



    public static void exit() {
        executor.shutdown();
        executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
    }
}