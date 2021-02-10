<%@page  import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Billing By  Mr/Ms..:<%=session.getAttribute("UserName") %></h3>
<h1>Welcome Mr/Ms <%=session.getAttribute("CustomerName") %></h1>
<h1>Contact <%=session.getAttribute("CustomerMobile") %></h1>
<h1>TotalAmount <%=session.getAttribute("TotalAmount") %></h1>
	<%
		session.removeAttribute("CustomerName");
		session.removeAttribute("UserName");
		session.removeAttribute("CustomerMobile");
		session.removeAttribute("TotalAmount");
		Enumeration<String> en=session.getAttributeNames();
		while(en.hasMoreElements()){
			String name=en.nextElement();
			String value=(String)session.getAttribute(name);
			String price=(String)session.getAttribute(name);
			out.println("<h1>"+name+":"+value+"</h1>");
			
		}
		session.invalidate();
		
	%>
</body>
</html>