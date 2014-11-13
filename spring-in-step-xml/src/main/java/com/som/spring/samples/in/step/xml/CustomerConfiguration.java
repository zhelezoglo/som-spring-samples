package com.som.spring.samples.in.step.xml;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class CustomerConfiguration {

    private DataSource dataSource;

    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(this.dataSource);
    }
}

