package com.thoughtworks.ab;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.thoughtworks.ab.repository.UserRepositoryImpl;
import com.thoughtworks.ab.viewmodel.UserProfileViewModel;
import com.thoughtworks.ab.viewmodel.UserRepository;
import com.thoughtworks.ab.viewmodel.UserVO;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
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
        UserVO userVO = new UserVO();
        userVO.setName("sjyuan");
        when(userRepository.find(anyString())).thenReturn(userVO);
        when(application.userRepository()).thenReturn(userRepository);
        UserProfileViewModel userProfileViewModel = new UserProfileViewModel(application);

        UserVO user = userProfileViewModel.findUser("123");

        assertThat(user.getName(), is("sjyuan"));
    }
}