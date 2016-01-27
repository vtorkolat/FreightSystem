package com.frightsystem.dao;

import com.frightsystem.model.User;

import java.util.HashMap;
import java.util.Map;


public class UserDao {
    private static UserDao instance;
    private Map<String, User> users = new HashMap<>();

    private UserDao() {}

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
