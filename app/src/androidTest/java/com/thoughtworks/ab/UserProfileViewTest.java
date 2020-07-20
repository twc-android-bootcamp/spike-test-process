
package com.thoughtworks.ab;

import android.view.View;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.thoughtworks.ab.view.MainActivity;
import com.thoughtworks.ab.view.UserProfileFragment;
import com.thoughtworks.ab.viewmodel.UserProfileViewModel;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.mockito.Mockito.mock;


@RunWith(AndroidJUnit4.class)
public class UserProfileViewTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void should_toast_correct_user() {
        MainActivity activity = (MainActivity) mActivityRule.getActivity();
        UserProfileFragment fragment = (UserProfileFragment) activity.getSupportFragmentManager()
                .findFragmentById(R.id.UserProfileFragment);

        fragment.setUserProfileViewModel(mock(UserProfileViewModel.class));

        onView(withId(R.id.button_loading)).perform(click());
        onView(withText("hello world")).inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
}