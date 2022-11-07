<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<b>Welcome to JSP</b>
		<br>
		<%
			out.println("Todays Date and Time :: "+new java.util.Date());
			int x = 10,y=30;
			out.println("Addition is :: "+(x+y));
		%>
		<br>
		Hello guys
		its normal text
</body>
</html>