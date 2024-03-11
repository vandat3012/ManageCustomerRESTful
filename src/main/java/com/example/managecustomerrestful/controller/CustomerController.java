package com.example.managecustomerrestful.controller;

import com.example.managecustomerrestful.model.Customer;
import com.example.managecustomerrestful.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAll() {
        Iterable<Customer> customers = iCustomerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Optional<Customer> customer = iCustomerService.findById(id);
        return new ResponseEntity<>(customer.get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Customer> saveCustomer (@RequestBody Customer customer){
        return new ResponseEntity<>(iCustomerService.save(customer),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable Long id,@RequestBody Customer customer) {
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(iCustomerService.save(customer),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete (@PathVariable Long id){
        Optional<Customer> customerOptional = iCustomerService.findById(id);
        iCustomerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(),HttpStatus.OK);
    }
}
