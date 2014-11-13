package com.som.spring.samples.in.step.xml;

import com.som.spring.samples.in.step.core.Customer;
import com.som.spring.samples.in.step.core.CustomerService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseCustomerService implements CustomerService {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Customer> customerRowMapper = new CustomerRowMapper();

    public Customer getCustomerById(long id) {
        return jdbcTemplate.queryForObject(
                "select * from CUSTOMERS where ID = ?", this.customerRowMapper, id);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class CustomerRowMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            String fn = resultSet.getString("FIRST_NAME");
            String ln = resultSet.getString("LAST_NAME");
            String email = resultSet.getString("EMAIL");
            long id = resultSet.getInt("ID");
            return new Customer(id, fn, ln, email);
        }
    }
}
