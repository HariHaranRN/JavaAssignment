<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<hr>
<%@ include file="logout.jsp" %>
<hr>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Welcome....:<%=session.getAttribute("UserName")%></h4>
	<h1>Welcome to Amazon shopping site...</h1>
	<form action="shop.do">
		<input type="hidden" name="formid" value="shop">
		
		<B>CustomerName</B>:<input type="text" name="CustomerName">
		<hr>
		<B>CustomerMobile</B><input type="text" name="CustomerMobile">
		<input type="submit" value="Next">
		<hr>
	</form>
</body>
</html>