package com.frightsystem.dao;

import com.frightsystem.model.User;

import java.util.List;

public interface UserDao {
    public User create(User user);

    public User read(int id);

    public boolean update(User user);

    public boolean delete(User user);

    public List<User> getAll();
}

