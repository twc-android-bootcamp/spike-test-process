package com.thoughtworks.ab;

import android.app.Application;

import androidx.room.Room;

import com.thoughtworks.ab.repository.AppDatabase;
import com.thoughtworks.ab.repository.DataSource;
import com.thoughtworks.ab.repository.UserRepositoryImpl;
import com.thoughtworks.ab.viewmodel.UserRepository;

public class MainApplication extends Application {
    private UserRepository userRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        userRepository = new UserRepositoryImpl(dbUserDataSource());
    }

    public UserRepository userRepository() {
        return userRepository;
    }

    public DataSource dbUserDataSource() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
        return db.userDBDataSource();
    }
}
