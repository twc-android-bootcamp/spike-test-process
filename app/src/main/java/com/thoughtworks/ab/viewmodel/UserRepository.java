package com.thoughtworks.ab.viewmodel;

import com.thoughtworks.ab.repository.entity.User;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public interface UserRepository {
    Maybe<User> find(String userId);

    Completable save(UserVO userVO);
}
