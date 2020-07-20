
package com.thoughtworks.ab;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.thoughtworks.ab.view.MainActivity;
import com.thoughtworks.ab.viewmodel.UserRepository;
import com.thoughtworks.ab.viewmodel.UserVO;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;


@RunWith(AndroidJUnit4.class)
public class UserRepositoryTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void should_find_correct_user() {
        MainApplication application = (MainApplication) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
        UserRepository userRepository = application.userRepository();
        UserVO userVO = new UserVO();
        userVO.setName(new Random().nextInt() + "");
        userVO.setLastName("Yuan");
        userVO.setId("12345");
        userRepository.save(userVO);
        assertThat(userRepository.find("12345").toString(), is(userVO.toString()));
    }
}