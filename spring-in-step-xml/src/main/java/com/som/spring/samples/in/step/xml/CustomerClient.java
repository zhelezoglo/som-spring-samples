package com.som.spring.samples.in.step.xml;

import com.som.spring.samples.in.step.core.Customer;
import com.som.spring.samples.in.step.core.CustomerService;

public class CustomerClient {
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void printCustomerInformation(long customerId) {
        Customer customer = this.customerService.getCustomerById(customerId);
        System.out.println(customer);
    }
}
