
package com.thoughtworks.ab;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.thoughtworks.ab.repository.AppDatabase;
import com.thoughtworks.ab.repository.UserRepositoryImpl;
import com.thoughtworks.ab.repository.entity.User;
import com.thoughtworks.ab.view.MainActivity;
import com.thoughtworks.ab.viewmodel.UserRepository;
import com.thoughtworks.ab.viewmodel.UserVO;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;
import java.util.function.Predicate;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.CoreMatchers.is;


@RunWith(AndroidJUnit4.class)
public class UserRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private AppDatabase appDatabase;

    private UserRepository userRepository;

    @Before
    public void setUp() {
        appDatabase = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getInstrumentation().getTargetContext(),
                AppDatabase.class).build();
        userRepository = new UserRepositoryImpl(appDatabase.userDBDataSource());
    }

    @After
    public void tearDown() {
        appDatabase.close();
    }

    @Test
    public void should_find_correct_user() {
        UserVO userVO = new UserVO();
        userVO.setName(new Random().nextInt() + "");
        userVO.setLastName("Yuan");
        userVO.setId("12345");
        appDatabase.userDBDataSource().save(userVO.toModel()).subscribeOn(Schedulers.io()).subscribe();
        userRepository.find("12345").test()
                .assertValue(user -> user.toString().equals(userVO.toModel().toString()));
    }
}