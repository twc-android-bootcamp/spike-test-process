package com.thoughtworks.ab.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.thoughtworks.ab.repository.entity.User;
import com.thoughtworks.ab.viewmodel.UserRepository;
import com.thoughtworks.ab.viewmodel.UserVO;

public class UserRepositoryImpl implements UserRepository {
    private DataSource cacheUerDataSource;
    private DataSource remoteUerDataSource;

    public UserRepositoryImpl(DataSource cacheUerDataSource, DataSource remoteUerDataSource) {
        this.cacheUerDataSource = cacheUerDataSource;
        this.remoteUerDataSource = remoteUerDataSource;
    }

    public LiveData<UserVO> find(String userId) {
        User user = cacheUerDataSource.find(userId);
        MutableLiveData<UserVO> result = new MutableLiveData<>();
        result.setValue(UserVO.fromModel(user));
        return result;
    }

    public void save(UserVO userVO) {
        cacheUerDataSource.save(userVO.toModel());
    }
}
