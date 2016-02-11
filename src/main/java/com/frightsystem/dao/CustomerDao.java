package com.frightsystem.dao;

import com.frightsystem.exceptions.DuplicateUserException;
import com.frightsystem.model.Customer;

import java.util.List;

public interface CustomerDao {

    public void create(Customer customer) throws DuplicateUserException;

    public Customer read(int id);

    public void update(Customer customer);

    public void delete(Customer customer);

    public List<Customer> getAll();
}
