package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM CUSTOMERS", new CustomerMapper());
	}

	private static final class CustomerMapper implements RowMapper<Customer> {
		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Customer customer = new Customer();
			customer.setName(rs.getString("NAME"));
			customer.setAddress(rs.getString("ADDRESS"));
			customer.setCustomerId(rs.getString("CUSTOMERID"));
			customer.setNoOfOrdersMade(rs.getInt("NOOFORDERMADE"));
			return customer;
		}

	}
}
