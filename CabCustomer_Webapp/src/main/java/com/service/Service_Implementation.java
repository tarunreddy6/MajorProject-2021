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

	public int deleteCustomer(int custid) throws ClassNotFoundException, SQLException {
		
		return new Customer_implementations().deleteCustomerById(custid);
	}

	public Customer getCustomer(int custid) throws ClassNotFoundException, SQLException {
		
		return new Customer_implementations().getCustomerById(custid);
	}
	
	public int updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		return new Customer_implementations().insertCustomer(customer);
	}

}
