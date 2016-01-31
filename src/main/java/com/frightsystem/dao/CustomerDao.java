package com.frightsystem.dao;



import com.frightsystem.model.Customer;

import java.util.List;

public interface CustomerDao {

    public Customer create();

    public Customer read(int id);

    public void update(Customer customer);

    public void delete(Customer customer);

    public List<Customer> getAll();
}
