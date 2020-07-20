package com.thoughtworks.ab.repository;

import com.thoughtworks.ab.repository.entity.User;

public interface DataSource {
    User find(String userId);

    void save(User user);
}
