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
	<spring:form commandName="CustomerBean" method="post" action="customersubmit">
	
		CustomerName:<spring:input path="CustomerName"/>
		CustomerMobile:<spring:input path="CustomerMobile"/>
		
		<input type="submit" value="login..">
		
	</spring:form>
</body>
</html>