<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Welcome....:<%=session.getAttribute("CustomerName")%></h4>
<form action="Items.do" >
<input type="hidden" name="formid" value="Items">
<input type="submit" value="click"/>
</form>

</body>
</html>