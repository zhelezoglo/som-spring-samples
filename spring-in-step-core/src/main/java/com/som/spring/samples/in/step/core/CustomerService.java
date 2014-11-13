package com.som.spring.samples.in.step.core;

import org.springframework.jdbc.core.JdbcTemplate;

public interface CustomerService {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    public Customer getCustomerById(long id);
}
