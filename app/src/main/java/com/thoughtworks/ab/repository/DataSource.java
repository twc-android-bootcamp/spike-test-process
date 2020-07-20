package com.thoughtworks.ab.repository;

import com.thoughtworks.ab.repository.entity.User;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public interface DataSource {
    Maybe<User> find(String userId);

    Completable save(User user);
}
