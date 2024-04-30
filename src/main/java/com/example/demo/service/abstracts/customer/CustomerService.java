package com.example.demo.service.abstracts.customer;

import com.example.demo.service.dtos.CustomerDTO;

public interface CustomerService {
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    void updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);
}