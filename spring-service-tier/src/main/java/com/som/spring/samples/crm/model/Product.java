package com.som.spring.samples.crm.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Product implements Serializable {
    private Long id;
    private String description;
    private String name;
    private double price;
    private Set lineItems = new HashSet();

    public Product(Long id, String description, String name, double price, Set lineItems) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.price = price;
        this.lineItems = lineItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set lineItems) {
        this.lineItems = lineItems;
    }
}
