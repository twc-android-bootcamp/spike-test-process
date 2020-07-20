package com.thoughtworks.ab.viewmodel;

import com.thoughtworks.ab.repository.entity.User;

public class UserVO {
    private String id;
    private String name;
    private String lastName;

    public User toModel() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setLastName(lastName);
        return user;
    }

    public static UserVO fromModel(User user) {
        if (user == null) {
            return null;
        }
        UserVO result = new UserVO();
        result.id = user.getId();
        result.lastName = user.getLastName();
        result.name = user.getName();
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
