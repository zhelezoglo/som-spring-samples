package com.som.spring.samples.crm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Purchase implements Serializable {
    private Long id;
    private Customer customer;
    private double total;
    private Set lineItems = new HashSet();

    public Purchase(Long id, Customer customer, double total, Set lineItems) {
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.lineItems = lineItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set lineItems) {
        this.lineItems = lineItems;
    }
}
