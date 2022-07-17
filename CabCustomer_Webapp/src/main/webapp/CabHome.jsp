<%@ page import="com.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Cab Home</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>


<body>
<%  List<Customer> customerList=(List<Customer>)request.getAttribute("allCustomers"); %>
<h1 align="center">Customer Details</h1>
<div class="container"> <!-- This div is for displaying the data from the data base -->
		<table class="table table-bordered">
			<tr class="bg-info">
			<th>custID</th>
			<th>customerName</th> 
			<th>pickupLocation</th>
			<th>dropLocation</th>
			<th>distance</th>
			<th>phoneNo</th>	
			</tr>
			<% for(Customer customer:customerList)
				{
					out.write("<tr class='bg-warning'>");
					out.write("<td>"+customer.getCustid()+"</td>");
					out.write("<td>"+customer.getName()+"</td>");
					out.write("<td>"+customer.getPickup()+"</td>");
					out.write("<td>"+customer.getDropup()+"</td>");
					out.write("<td>"+customer.getDistance()+"</td>");
					out.write("<td>"+customer.getPhoneNum()+"</td>");
					out.write("</tr>");
					}
			%>
		</table>
</div>
	
<div class="container">
	<a href="./AddCustomer.html" class="btn btn-info" role = "button">Add Customer</a>
</div>	   
</body>
</html>