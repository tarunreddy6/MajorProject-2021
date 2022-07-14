<%@ page import="com.entity.Team" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 </head>


<body>
<%  List<Team> teamList=(List<Team>)request.getAttribute("allTeams"); %>
<h1 align="center">Welcome to IPL 2022 Season</h1>
<div class="container"> <!-- This div is for displaying the data from the data base -->
		<table class="table table-bordered">
			<tr class="bg-info">
			<th>TeamId</th>
			<th>Name</th> 
			<th>City</th>
			<th>State</th>	
			</tr>
			<% for(Team team:teamList)
				{
				out.write("<tr class='bg-warning'>");
				out.write("<td>"+team.getTeamid()+"</td>");
				out.write("<td>"+team.getName()+"</td>");
				out.write("<td>"+team.getCity()+"</td>");
				out.write("<td>"+team.getState()+"</td>");
				out.write("</tr>");
				}
			%>
		</table>
</div>

<div class="container">
	<a href="./Addteam.html" class="btn btn-info" role = "button">AddTeam</a>
</div>
</body>
</html>