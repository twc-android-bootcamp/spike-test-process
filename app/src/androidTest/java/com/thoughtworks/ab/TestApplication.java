package com.thoughtworks.ab;

import com.thoughtworks.ab.repository.UserRepositoryImpl;
import com.thoughtworks.ab.viewmodel.UserProfileViewModel;
import com.thoughtworks.ab.viewmodel.UserRepository;

import static org.mockito.Mockito.mock;

public class TestApplication extends MainApplication {
    private UserRepository userRepository;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public UserRepository userRepository() {
        if (userRepository == null) {
            userRepository = mock(UserRepositoryImpl.class);
        }
        return userRepository;
    }
}
