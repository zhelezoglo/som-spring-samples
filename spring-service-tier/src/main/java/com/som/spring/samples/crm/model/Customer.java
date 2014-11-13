package com.som.spring.samples.crm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Set purchases = new HashSet();

    public Customer(Long id, String firstName, String lastName, Set purchases) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.purchases = purchases;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set getPurchases() {
        return purchases;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPurchases(Set purchases) {
        this.purchases = purchases;
    }
}
