<%@ page import="java.util.Date,java.util.ArrayList" %>
<hr>
<%@ include file="header.jsp" %>
<hr>
session,request,response,out,config,application,pageContext,exception,page
<%

out.println("hello world");
//session.setAttribute(arg0, arg1);
met();
out.println(new Date());
%>
<h1>
<%="hello world"%>
</h1>
<%!
int i=10;
public void met(){
	System.out.println("i value...:"+i);
}
%>
implicit objects 
scripting tags
	scriplet
	expression
	declaration
directive tags
	page directive <%@ page %>
	include directive
	taglib directive
	