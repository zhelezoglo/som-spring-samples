package com.som.spring.samples.crm.services;


import com.som.spring.samples.crm.model.Customer;

public interface CustomerRepository {
    Customer saveCustomer(Customer customer);

    Customer getCustomerById(long id);
}
