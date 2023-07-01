<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="SignUpCtrl" method="post">

		<table>
			<tr>
				<th>First Name :</th>
				<td><input type="text" name="first_name"></td>
			</tr>
			<tr>
				<th>Last Name :</th>
				<td><input type="text" name="last_name"></td>
			</tr>
			<tr>
				<th>Login Id :</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="Sign-up"></td>
			</tr>
		</table>
	</form>
</body>
</html>