package com.example.aman.to_doapp.presenters;

import com.example.aman.to_doapp.interfaces.IModel;
import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.interfaces.IView;
import com.example.aman.to_doapp.models.Todo;

import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Aman on 2/15/17.
 */

public class Presenter implements IPresenter {

    private String[] randomNames = new String[] {"Todo 1", "Todo 2", "Todo 3"};
    private Random random = new Random();

    private IModel<Todo> db;
    private final IView view;

    public Presenter(IView view, IModel<Todo> dataSource) {
        this.view = view;
        this.db = dataSource;
    }

    @Override
    public List<Todo> getTodos() {
        return db.getTodos();
    }

    @Override
    public void handleClick(int adapterPosition) {
        view.showEditView(adapterPosition);
        view.refreshTodos(db.getTodos());
        db.edit(getTodos().get(adapterPosition), getTodos().get(adapterPosition).id);
    }

    @Override
    public void handleLongPress(int position) {
        view.handleDelete(position);
        removeTodo(db.getTodos().get(position));
        view.refreshTodos(db.getTodos());
    }

    @Override
    public void removeTodo(Todo todo) {
        db.delete(todo);
    }

    @Override
    public void handleAddClick() {
        addTodo();
    }


    @Override
    public void addTodo() {
        Todo todo = new Todo();
        todo.name = getRandomName();
        todo.contents = getRandomName();
        todo.dueDate = "05/01";
        todo.id = UUID.randomUUID();
        db.add(todo);
        view.refreshTodos(db.getTodos());
    }


    @Override
    public void finish() {
        db.close();
    }

    private String getRandomName() {
        int randomIndex = random.nextInt(randomNames.length);
        return randomNames[randomIndex];
    }

}
