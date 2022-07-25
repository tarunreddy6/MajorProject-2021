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
		
		String RequestType = request.getParameter("request_type");
		PrintWriter out = response.getWriter();
		
		if(RequestType.equalsIgnoreCase("addCustomer")) {
			
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
					out.write("<h1>Not Inserted</h1>");
					rd = request.getRequestDispatcher("CabHome.jsp");
				}
				else
					doGet(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if (RequestType.equalsIgnoreCase("ModifyCustomer")) {
			
			try {
				int custid = Integer.parseInt(request.getParameter("custid"));
				Customer customer = new Service_Implementation().getCustomer(custid);
				request.setAttribute("customer", customer);
				RequestDispatcher rd = request.getRequestDispatcher("EditCustomer.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
			}
		}
		else if(RequestType.equalsIgnoreCase("Update")) {
						
			try {
				String name = request.getParameter("customerName");
				String pickup = request.getParameter("pickupLocation");
				String dropup = request.getParameter("dropLocation");
				Float distance = Float.parseFloat(request.getParameter("distance"));
				long phoneNum = Long.parseLong(request.getParameter("phoneNum"));
				int custid = Integer.parseInt(request.getParameter("custid"));
				
				Customer customer = new Customer();
				customer.setName(name);
				customer.setDropup(dropup);
				customer.setPickup(pickup);
				customer.setDistance(distance);
				customer.setPhoneNum(phoneNum);
				customer.setCustid(custid);
				int r = new Service_Implementation().updateCustomer(customer);
				if(r!=0)
					doGet(request,response);
				else
					out.write("<html><body><h2 style='color: red'> Not Updated </h2></body></html>");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
			}
		}
		else if (RequestType.equalsIgnoreCase("DeleteCustomer")) {
			
			try {
				int custid = Integer.parseInt(request.getParameter("custid"));
				int i = new Service_Implementation().deleteCustomer(custid);
				if(i!=0)
					doGet(request,response);
				else
					out.write("<h1 style='color:red'> Not Deleted</h1>");
				} catch (ClassNotFoundException | SQLException e) {
					System.out.println(e);
				}
		}
	}
}