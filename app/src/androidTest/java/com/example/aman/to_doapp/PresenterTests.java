package com.example.aman.to_doapp;

import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.interfaces.ITodoService;
import com.example.aman.to_doapp.interfaces.IView;
import com.example.aman.to_doapp.models.Todo;
import com.example.aman.to_doapp.models.TodosModel;
import com.example.aman.to_doapp.presenters.Presenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Aman on 2/20/17.
 */

public class PresenterTests {

    @Mock
    IView view;

    @Mock
    ITodoService todoService;

    @Before
    public void setup() {
        initMocks(this);
    }

    private List<Todo> makeTestTodos() {
        List<Todo> todos = new ArrayList<>();

        Todo todo = new Todo();
        todo.setName("Test 1");
        todos.add(todo);

        todo = new Todo();
        todo.setName("Test 2");
        todos.add(todo);

        return todos;
    }

    @Test
    public void Test_InitialTodoShouldBeFirstTodo() {
        List<Todo> todos = makeTestTodos();

        when(todoService.getTodos()).thenReturn(todos);
        IPresenter presenter = new Presenter(view, new TodosModel(todoService));
        Todo expectedTodo = presenter.getCurrentTodo();

        Assert.assertEquals(todos.get(0).getName(), expectedTodo.getName());
        verify(view).displayTodo(expectedTodo);
    }
    


    @Test
    public void Test_OpenAddActivity() {
        IPresenter presenter = new Presenter(view, new TodosModel(todoService));

        presenter.showAddOrEditView(null);

        verify(view).showAddView();

    }

    @Test
    public void Test_OpenEditActivity() {
        IPresenter presenter = new Presenter(view, new TodosModel(todoService));

        Todo todo = new Todo();
        presenter.showAddOrEditView(todo);

        verify(view).showEditView();

    }


}
