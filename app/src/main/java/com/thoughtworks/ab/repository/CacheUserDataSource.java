package com.thoughtworks.ab.repository;

import com.thoughtworks.ab.repository.entity.User;

import java.util.HashMap;
import java.util.Map;

public class CacheUserDataSource implements DataSource {
    private static Map<String, User> users = new HashMap<>();

    public User find(String userId) {
        return users.get(userId);
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }
}
