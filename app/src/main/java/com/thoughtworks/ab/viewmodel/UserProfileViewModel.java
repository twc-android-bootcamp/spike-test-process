package com.thoughtworks.ab.viewmodel;

import androidx.lifecycle.ViewModel;

import com.thoughtworks.ab.repository.entity.User;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public class UserProfileViewModel extends ViewModel {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Maybe<User> findUser(String userId) {
        return userRepository.find(userId);
    }

    public Completable save(UserVO userVO) {
        return userRepository.save(userVO);
    }
}
