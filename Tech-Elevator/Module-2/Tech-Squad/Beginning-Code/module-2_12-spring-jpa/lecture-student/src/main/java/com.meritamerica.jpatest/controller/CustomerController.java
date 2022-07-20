package com.meritamerica.jpatest.controller;

import com.meritamerica.jpatest.dao.CustomerRepository;
import com.meritamerica.jpatest.dao.PersonRepository;
import com.meritamerica.jpatest.model.Customer;
import com.meritamerica.jpatest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers/findByLastName/{lastName}")
    public List<Customer> findByLastName(@PathVariable String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }


    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

}
