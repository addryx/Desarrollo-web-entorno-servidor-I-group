<%@page import="com.edix.clientes.modelo.beans.Evento"%>
<%@page import="java.util.List"%>
<%@page import="com.edix.clientes.modelo.repository.EventoDaoImpl"%>
<%@page import="com.edix.clientes.modelo.repository.IntEventoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de Inicio</title>
</head>
<body>
	<%List<Evento> activos = (List<Evento>)request.getAttribute("listaActivos");%>
	
	<h2>Tipo de Eventos</h2>
	
	<p><a href="/clientes/login">Login</a></p>
	<p><a href="#">Registro</a></p>
	
	<h2>Listado de eventos activos</h2>
	<h3>${mensaje}</h3>
	<p>Inicie sesión para ver más.</p>
	
	<table border="2">
	<tr>
	<th>Nombre</th><th>Aforo</th><th>Fecha inicio</th>
	</tr>
	<% for (Evento ele: activos){ %>
		<tr>
		<td><%= ele.getNombre() %></td>
		<td><%= ele.getAforoMaximo() %></td>
		<td><%= ele.getFechaInicio() %></td>
		</tr>
	<%} %>
	</table>
</body>
</html>