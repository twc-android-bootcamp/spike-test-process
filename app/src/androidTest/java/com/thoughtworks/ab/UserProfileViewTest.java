package com.thoughtworks.ab;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.thoughtworks.ab.repository.entity.User;
import com.thoughtworks.ab.view.MainActivity;
import com.thoughtworks.ab.viewmodel.UserRepository;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.internal.operators.maybe.MaybeCreate;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(AndroidJUnit4.class)
public class UserProfileViewTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void should_display_correct_user_info() {
        MainApplication applicationContext = (MainApplication) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
        UserRepository userRepository = applicationContext.userRepository();
        User user = new User();
        user.setId("123");
        user.setName("sjyuan");
        user.setLastName("Yuan");
        when(userRepository.find(anyString())).thenReturn(new MaybeCreate(emitter -> emitter.onSuccess(user)));

        onView(withId(R.id.button_loading)).perform(click());
        onView(withId(R.id.textview_first)).check(matches(withText(user.toString())));
    }
}