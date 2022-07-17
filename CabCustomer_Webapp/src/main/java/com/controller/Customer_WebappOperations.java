package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Customer;
import com.service.Service_Implementation;

/**
 * Servlet implementation class Customer_WebappOperations
 */
@WebServlet("/Customer_WebappOperations")
public class Customer_WebappOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer_WebappOperations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			List<Customer> customerList = new Service_Implementation().fetchAllCustomers();
			request.setAttribute("allCustomers", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("CabHome.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			
			Customer customer = new Customer();
			customer.setName(request.getParameter("customerName"));
			customer.setPickup(request.getParameter("pickupLocation"));
			customer.setDropup(request.getParameter("dropLocation"));
			customer.setDistance(Float.parseFloat(request.getParameter("distance")));
			customer.setPhoneNum(Long.parseLong(request.getParameter("phoneNum")));
			int r = new Service_Implementation().addCustomer(customer);
			RequestDispatcher rd = null;
			if(r==0) {
				out.write(",h1>Not Inserted</h1>");
				rd = request.getRequestDispatcher("CabHome.jsp");
			}
			else
				doGet(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
