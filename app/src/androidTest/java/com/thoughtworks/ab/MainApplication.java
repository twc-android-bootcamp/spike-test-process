package com.thoughtworks.ab;

import android.app.Application;

import androidx.room.Room;

import com.thoughtworks.ab.repository.AppDatabase;
import com.thoughtworks.ab.repository.DataSource;
import com.thoughtworks.ab.repository.UserRepositoryImpl;
import com.thoughtworks.ab.viewmodel.UserRepository;

import static org.mockito.Mockito.mock;

public class MainApplication extends Application {
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
