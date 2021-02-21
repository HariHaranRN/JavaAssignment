<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<hr>
<%@ include file="logout.jsp" %>
<h3>Welcome Mr..<%=session.getAttribute("UserName") %></h3>
<hr>
<h1>Fruit shop</h1>
	<form action="shopping.do" method="post">
		<input type="hidden" name="formid" value="shopping">
		<input type="hidden" name="shopid" value="shop2">
		<input type="checkbox" name="c4" value="Mango">:Mango
		<input type="checkbox" name="c5" value="Banana">:Banana
		<input type="checkbox" name="c6" value="Orange">:Orange
	
		<input type="submit" value="NextShop...">
	</form>
	
	
</body>
</html>