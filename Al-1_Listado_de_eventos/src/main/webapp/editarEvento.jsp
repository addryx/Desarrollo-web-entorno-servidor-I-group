<%@page import="modelo.javabeans.Evento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar evento</title>
</head>
<body>
	<%
	Evento evento = (Evento)request.getAttribute("evento");
	%>

	<p>
		Descripción: <%=evento.getDescripcion()%>
	</p>
</body>
</html>