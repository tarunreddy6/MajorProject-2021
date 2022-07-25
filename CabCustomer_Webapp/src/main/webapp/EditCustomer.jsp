<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Customer Details</title>
</head>
<body>
	<form method="post" action = "Customer_WebappOperations">
		CustomerId:<input type="hidden" name="custid" value="${customer.custid}"><br><br>
		Name:<input type="text" name="customerName" value="${customer.name}"><br><br>
		PickUp:<input type="text" name="pickupLocation" value="${customer.pickup}"><br><br>
		DropUp<input type="text" name="dropLocation" value="${customer.dropup}"><br><br>
		Distance<input type="text" name="distance" value="${customer.distance}"><br><br>
		MobileNumber<input type="text" name="phoneNum" value="${customer.phoneNum}"><br><br>
		<input type="submit" name="request_type" value="Update">
	</form>
</body>
</html>