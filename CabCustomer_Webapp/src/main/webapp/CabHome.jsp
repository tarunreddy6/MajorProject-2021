<%@ page import="com.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
<h1 align="center">Customer Details</h1>
<form action = "Customer_WebappOperations" method = "post" >
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
			<c:forEach var="customer" items = "${requestScope.allCustomers}">
			<tr>
				<td><input type="radio" value = "${customer.custid}" name = "custid">${customer.custid} </td>
				<td>${customer.name}</td>
				<td>${customer.pickup}</td>
				<td>${customer.dropup}</td>
				<td>${customer.distance}</td>
				<td>${customer.phoneNum}</td>
			</tr>
			</c:forEach>
			
		</table>
</div>
	
<div class="container">
	<a href="./AddCustomer.html" class="btn btn-info" role = "button">Add Customer</a>
	<input type = "submit" class="btn btn-info" name = "request_type" value = "ModifyCustomer" />
	<input type = "submit" class = "btn btn-info" name = "request_type" value = "DeleteCustomer" />
	
</div>
</form>	   
</body>
</html>