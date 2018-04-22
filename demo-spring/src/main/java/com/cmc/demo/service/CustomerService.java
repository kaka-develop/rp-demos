package com.cmc.demo.service;

import com.cmc.demo.model.Customer;
import com.cmc.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    public Customer save(Customer customer){
        return this.customerRepository.save(customer);
    }

    public boolean delete(int id){
        return this.customerRepository.deleteById(id) > 0;
    }

    public Customer findById(int id) {
        return this.customerRepository.findOne(id);
    }
}
