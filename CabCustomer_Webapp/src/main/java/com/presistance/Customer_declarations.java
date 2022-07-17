package com.presistance;

import java.sql.SQLException;
import java.util.List;

import com.entity.Customer;

public interface Customer_declarations {
	
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException;
	public int insertCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	public int deleteCustomerById(int custid);
	public Customer getCustomerById(int custid);
}
