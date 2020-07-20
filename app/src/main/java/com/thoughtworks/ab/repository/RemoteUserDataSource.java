package com.thoughtworks.ab.repository;

import com.thoughtworks.ab.repository.entity.User;

public class RemoteUserDataSource implements DataSource{
    @Override
    public User find(String userId) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
