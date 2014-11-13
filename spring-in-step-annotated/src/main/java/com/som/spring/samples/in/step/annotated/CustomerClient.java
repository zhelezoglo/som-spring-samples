package com.som.spring.samples.in.step.annotated;

import com.som.spring.samples.in.step.core.Customer;
import com.som.spring.samples.in.step.core.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerClient {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void printCustomerInformation(long customerId) {
        Customer customer = this.customerService.getCustomerById(customerId);
        System.out.println(customer);
    }
}
