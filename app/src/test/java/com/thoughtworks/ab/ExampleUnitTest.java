package com.thoughtworks.ab;

import android.app.Application;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.thoughtworks.ab.viewmodel.UserProfileViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Mock
    Observer<Integer> observer;

    private UserProfileViewModel mainViewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mainViewModel = new UserProfileViewModel(mock(Application.class));
    }

    @Test
    public void addition_isCorrect() {
    }
}