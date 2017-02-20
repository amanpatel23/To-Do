package com.example.aman.to_doapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.aman.to_doapp.interfaces.IPresenter;
import com.example.aman.to_doapp.interfaces.IView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
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
    public void TestNextButtonCallsCorrectMethodOnPresenter() {

        MainActivity activity = mActivity.getActivity();
        activity.setPresenter(presenter);

        onView(withId(R.id.nextBtn)).perform(click());

        verify(presenter).handleNextBtnClick();
    }


    @Test
    public void TestPrevButtonCallsCorrectMethodOnPresenter() {

        MainActivity activity = mActivity.getActivity();
        activity.setPresenter(presenter);

        onView(withId(R.id.prevBtn)).perform(click());

        verify(presenter).handlePrevBtnClick();
    }



}

