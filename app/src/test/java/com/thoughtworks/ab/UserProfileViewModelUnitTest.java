package com.thoughtworks.ab;

import com.thoughtworks.ab.repository.UserRepositoryImpl;
import com.thoughtworks.ab.repository.entity.User;
import com.thoughtworks.ab.viewmodel.UserProfileViewModel;
import com.thoughtworks.ab.viewmodel.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.internal.operators.maybe.MaybeCreate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserProfileViewModelUnitTest {
    @Mock
    private MainApplication application;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_find_correct_user() {
        UserRepository userRepository = mock(UserRepositoryImpl.class);
        User user = new User();
        user.setName("sjyuan");
        when(userRepository.find(anyString())).thenReturn(new MaybeCreate(emitter -> emitter.onSuccess(user)));
        UserProfileViewModel userProfileViewModel = new UserProfileViewModel();
        userProfileViewModel.setUserRepository(userRepository);

        User result = userProfileViewModel.findUser("123").blockingGet();

        assertThat(user.getName(), is("sjyuan"));
    }
}