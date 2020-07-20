package com.thoughtworks.ab.viewmodel;

import androidx.lifecycle.LiveData;

import com.thoughtworks.ab.repository.entity.User;

public interface UserRepository {
    LiveData<UserVO> find(String userId);

    void save(UserVO userVO);
}
