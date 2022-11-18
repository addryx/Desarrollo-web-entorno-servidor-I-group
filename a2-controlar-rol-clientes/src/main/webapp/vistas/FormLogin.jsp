<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="/clientes/login" method="post"><br>
		Username: <input type="text" name= "username"><br>
		<br>
		Password: <input type="password" name= "password"><br>
		<br>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>