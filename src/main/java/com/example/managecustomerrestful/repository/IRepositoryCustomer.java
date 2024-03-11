package com.example.managecustomerrestful.repository;

import com.example.managecustomerrestful.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCustomer extends CrudRepository<Customer,Long> {
}
