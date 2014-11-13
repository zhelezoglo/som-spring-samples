package com.som.spring.samples.in.step.core;


public class Customer {
    private long id;
    private String fn;
    private String ln;
    private String email;

    public Customer(long id, String fn, String ln, String email) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getFn() {
        return fn;
    }

    public String getLn() {
        return ln;
    }

    public String getEmail() {
        return email;
    }
}
