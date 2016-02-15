package com.frightsystem.dao;

import com.frightsystem.exceptions.DuplicateUserException;
import com.frightsystem.model.Customer;

import java.util.List;

public interface CustomerDao {

    public Customer create(Customer customer) throws DuplicateUserException;

    public Customer read(int id);

    public boolean update(Customer customer);

    public boolean delete(Customer customer);

    public List<Customer> getAll();
}
