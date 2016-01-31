package com.frightsystem.dao;

import com.frightsystem.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface UserDao {

    public User create();

    public User read(int id);

    public void update(User user);

    public void delete(User user);

    public List<User> getAll();


}
