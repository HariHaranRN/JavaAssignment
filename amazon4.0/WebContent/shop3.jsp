<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="orange">
<hr>
<%@ include file="logout.jsp" %>
<h3>Welcome Mr..<%=session.getAttribute("UserName") %></h3>
<hr>
<h1>Meat shop</h1>
	<form action="shopping.do" method="post">
		<input type="hidden" name="formid" value="shopping">
		<input type="hidden" name="shopid" value="shop3">
		<input type="checkbox" name="c7" value="Mutton">:Mutton
		<input type="checkbox" name="c8" value="Chicken">:Chicken
		<input type="checkbox" name="c9" value="Chops">:Chops
	
		<input type="submit" value="Invoice...">
	</form>
	
	
</body>
</html>