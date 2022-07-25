package com.presistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Customer;

public class Customer_implementations implements Customer_declarations {


	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException { // get data from the database
		
		List<Customer> customerList = new ArrayList<Customer>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cohort24","root","password");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from cabcustomer");
		
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setCustid(rs.getInt(1));
			customer.setName(rs.getString(2));
			customer.setPickup(rs.getString(3));
			customer.setDropup(rs.getString(4));
			customer.setDistance(rs.getFloat(5));
			customer.setPhoneNum(rs.getLong(6));
			customerList.add(customer);
		}
		return customerList;
	}
	
	public int insertCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cohort24","root","password");
		PreparedStatement ps = con.prepareStatement("insert into cabcustomer(customerName,pickupLocation, dropLocation, distance, phoneNo) values(?,?,?,?,?)");
		ps.setString(1, customer.getName());
		ps.setString(2, customer.getPickup());
		ps.setString(3, customer.getDropup());
		ps.setFloat(4, customer.getDistance());
		ps.setLong(5, customer.getPhoneNum());
		
		int r = ps.executeUpdate();
		System.out.println("Inserted "+r+" row.");
		con.close();
		return r;
	}

	
	public int deleteCustomerById(int custid) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cohort24","root","password");
		PreparedStatement ps = con.prepareStatement("delete from cabcustomer where custID=?");
		ps.setInt(1, custid);
		
		int r = ps.executeUpdate();
		return r;
	}

	public Customer getCustomerById(int custid) throws ClassNotFoundException, SQLException {
		
		Customer customer = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cohort24","root","password");
		PreparedStatement ps = con.prepareStatement("select * from cabcustomer where custID=?");
		ps.setInt(1, custid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			customer = new Customer();
			customer.setName(rs.getString(2));
			customer.setPickup(rs.getString(3));
			customer.setDropup(rs.getString(4));
			customer.setDistance(rs.getFloat(5));
			customer.setPhoneNum(rs.getLong(6));
		}
		return customer;
	}

	public int updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cohort24","root","password");
		PreparedStatement ps = con.prepareStatement("update cabcustomer set customerName=?,pickupLocation=?,dropLocation=?,distance=?,phoneNo=? where custID=?");
		ps.setString(1, customer.getName());
		ps.setString(2, customer.getPickup());
		ps.setString(3, customer.getDropup());
		ps.setFloat(4, customer.getDistance());
		ps.setLong(5, customer.getPhoneNum());
		ps.setInt(6, customer.getCustid());		
		int r = ps.executeUpdate();
		System.out.println(r);
		return r;
	}

}
