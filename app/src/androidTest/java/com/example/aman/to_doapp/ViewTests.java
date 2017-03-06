package com.example.aman.to_doapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.aman.to_doapp.interfaces.IPresenter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Aman on 2/20/17.
 */

@RunWith(AndroidJUnit4.class)
public class ViewTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivity = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Mock
    IPresenter presenter;

    @Before
    public void setup() {
        initMocks(this);
    }


    @Test
    public void TestEditButtonCallsCorrectMethodOnPresenter() {

        MainActivity activity = mActivity.getActivity();
        activity.setPresenter(presenter);

        onView(withId(R.id.TodoItemNameTextView)).perform(click());

        verify(presenter).handleClick(1);
    }


    @Test
    public void TestAddButtonCallsCorrectMethodOnPresenter() {

        MainActivity activity = mActivity.getActivity();
        activity.setPresenter(presenter);

        onView(withId(R.id.add_todo_button)).perform(click());

        verify(presenter).handleAddClick();
    }

    @Test
    public void TestDeleteCallsCorrectMethodOnPresenter() {

        MainActivity activity = mActivity.getActivity();
        activity.setPresenter(presenter);

        onView(withId(R.id.add_todo_button)).perform(longClick());

        verify(presenter).handleLongPress(1);
    }



}

