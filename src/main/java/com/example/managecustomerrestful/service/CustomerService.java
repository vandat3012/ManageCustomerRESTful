package com.example.managecustomerrestful.service;

import com.example.managecustomerrestful.model.Customer;
import com.example.managecustomerrestful.repository.IRepositoryCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private IRepositoryCustomer iRepositoryCustomer;
    @Override
    public Iterable<Customer> findAll() {
        return iRepositoryCustomer.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return iRepositoryCustomer.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        iRepositoryCustomer.save(customer);
        return customer;
    }

    @Override
    public void remove(Long id) {
        iRepositoryCustomer.deleteById(id);
    }
}
