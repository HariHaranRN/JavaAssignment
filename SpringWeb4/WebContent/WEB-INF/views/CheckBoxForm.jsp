<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:form commandName="list" method="post" action="processcheckboxform">
	
		<spring:checkboxes items="${modelitemlist}" path="itemList"/>
		<input type="submit" value="Purchase..">
		
	</spring:form>
	
</body>
</html>