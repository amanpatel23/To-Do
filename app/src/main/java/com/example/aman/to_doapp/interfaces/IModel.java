package com.example.aman.to_doapp.interfaces;

import java.util.List;

/**
 * Created by Aman on 2/15/17.
 */

public interface IModel<T> {
    List<T> getTodos();
    void add(T todo);
    void edit(T todo);
    void delete(T todo);
    void close();

}
