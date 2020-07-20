package com.thoughtworks.ab.repository;

import com.thoughtworks.ab.repository.entity.User;
import com.thoughtworks.ab.viewmodel.UserRepository;
import com.thoughtworks.ab.viewmodel.UserVO;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public class UserRepositoryImpl implements UserRepository {
    private DataSource dbUserDataSource;

    public UserRepositoryImpl(DataSource dbUserDataSource) {
        this.dbUserDataSource = dbUserDataSource;
    }

    public Maybe<User> find(String userId) {
        return dbUserDataSource.find(userId);
    }

    public Completable save(UserVO userVO) {
        return dbUserDataSource.save(userVO.toModel());
    }
}
