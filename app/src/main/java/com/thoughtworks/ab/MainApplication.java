package com.thoughtworks.ab;

import android.app.Application;

import com.thoughtworks.ab.repository.CacheUserDataSource;
import com.thoughtworks.ab.repository.DataSource;
import com.thoughtworks.ab.repository.RemoteUserDataSource;
import com.thoughtworks.ab.repository.UserRepositoryImpl;
import com.thoughtworks.ab.viewmodel.UserRepository;

public class MainApplication extends Application {
    private UserRepository userRepository;
    private DataSource cacheUserDataSource;
    private DataSource remoteUserDataSource;

    @Override
    public void onCreate() {
        super.onCreate();
        cacheUserDataSource = new CacheUserDataSource();
        remoteUserDataSource = new RemoteUserDataSource();
        userRepository = new UserRepositoryImpl(cacheUserDataSource, remoteUserDataSource);
    }

    public UserRepository userRepository() {
        return userRepository;
    }

    public DataSource cacheUserDataSource() {
        return cacheUserDataSource;
    }

    public DataSource remoteDataSource() {
        return remoteUserDataSource;
    }
}
