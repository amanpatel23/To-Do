package com.example.aman.to_doapp.interfaces;

import java.util.List;
import java.util.UUID;

/**
 * Created by Aman on 2/15/17.
 */

public interface IModel<T> {
    List<T> getTodos();
    void add(T todo);
    void edit(T todo, UUID originalTodoID);
    void delete(T todo);
    void close();

}
