 <%@page import="in.co.rays.bean.UserBean"%>
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
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<form action="UserCtrl.do" method="post">
		<td><input type="hidden" name="id" value=<%=bean.getId()%>></td>
		<table>
			<tr>
				<th>First Name :</th>
				<td><input type="text" name="first_name"
					value="<%=bean.getFirstName()%>"></td>
			</tr>
			<tr>
				<th>Last Name :</th>
				<td><input type="text" name="last_name"
					value="<%=bean.getLastName()%>"></td>
			</tr>
			<tr>
				<th>Login Id :</th>
				<td><input type="text" name="loginId"
					value="<%=bean.getloginId()%>"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"
					value="<%=bean.getPassword()%>"></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td><input type="text" name="address"
					value="<%=bean.getAddress()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" name="operation" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>