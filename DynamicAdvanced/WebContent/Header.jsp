<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String fname = (String) session.getAttribute("fName");
	%>
	<%
		if (fname != null) {
	%>
	<h3>
		Hello,
		<%=fname%></h3>
	<a href="UserListCtrl.do">UserList</a> ||
	<a href="LoginCtrl?operation=Logout">Logout</a>
	<%
		} else {
	%>
	<h3>Hello, Guest</h3>
	<%
		}
	%>
	<hr>
</body>
</html>