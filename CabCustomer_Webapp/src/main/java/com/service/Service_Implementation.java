package com.service;

import java.sql.SQLException;
import java.util.List;

import com.entity.Customer;
import com.presistance.Customer_implementations;

public class Service_Implementation {
	
public List<Customer> fetchAllCustomers() throws ClassNotFoundException, SQLException {
		
		return new Customer_implementations().getAllCustomers();
	}

	
	public int addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		return new Customer_implementations().insertCustomer(customer);
	}

	
	public int deleteCustomer(int custid) {
		
		return 0;
	}

	
	public Customer getCustomer(int custid) {
		
		return null;
	}

}
