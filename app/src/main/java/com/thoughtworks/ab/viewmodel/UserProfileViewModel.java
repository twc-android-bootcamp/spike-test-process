package com.thoughtworks.ab.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.thoughtworks.ab.MainApplication;
import com.thoughtworks.ab.repository.entity.User;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public class UserProfileViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
        userRepository = ((MainApplication) application).userRepository();
    }

    public Maybe<User> findUser(String userId) {
        return userRepository.find(userId);
    }

    public Completable save(UserVO userVO) {
        return userRepository.save(userVO);
    }
}
