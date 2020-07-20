package com.thoughtworks.ab.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.thoughtworks.ab.MainApplication;

public class UserProfileViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
        MainApplication mainApplication = (MainApplication) application;
        userRepository = mainApplication.userRepository();
    }

    public LiveData<UserVO> findUser(String userId) {
        return userRepository.find(userId);
    }

    public void save(String name, String lastName) {
        UserVO user = new UserVO();
        user.setId("123");
        user.setName(name);
        user.setLastName(lastName);
        userRepository.save(user);
    }
}
