<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ItemPackage.ItemDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="red">
<hr>
<%@ include file="logout.jsp" %>
<h3>Welcome Mr..<%=session.getAttribute("UserName") %></h3>
<h3>Customer Mr..<%=session.getAttribute("CustomerName") %></h3>
<hr>
<%
ItemDTO obj=(ItemDTO)session.getAttribute("Items");
String []Image=obj.getItemImage();
String []Description=obj.getItemDescription();
int []Price=obj.getPrice();
int []itemid=obj.getItemId();
out.println(Image[0]);
%>

<h1>Vegetable shop</h1>

	<form action="shopping.do" method="post">
		<input type="hidden" name="formid" value="shopping">
		<input type="hidden" name="shopid" value="shop1">
		<input type="checkbox" name=<%=itemid[0]%> value= <%=Description[0]%> >:<%=Description[0]%> 
		<input type="number" name=<%=Description[0]%>>
		<p>price:<%=Price[0]%>   </p>
		<hr>
		<img src=<%=Image[0]%> width=100px >
		<hr>
	
		<hr>
		<input type="checkbox" name=<%=itemid[1]%> value=<%=Description[1]%> >:<%=Description[1]%> 
		<input type="number" name=<%=Description[1]%>>
		<p>price:<%=Price[1]%></p>
		<hr>
		<img src=<%=Image[1]%> width=100px >
		<hr>
		
		<hr>
		<input type="checkbox" name=<%=itemid[2]%> value=<%=Description[2]%> >:<%=Description[2]%> 
		<input type="number" name=<%=Description[2]%>>
		<p>price:<%=Price[2]%>   </p>
		<hr>
		<img src=<%=Image[2]%> width=100px >
		<hr>
		
		<input type="submit" value="ok">
		</form>
	
	
</body>
</html>