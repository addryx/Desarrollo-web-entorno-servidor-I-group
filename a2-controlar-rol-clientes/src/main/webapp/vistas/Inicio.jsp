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
	
	<table border="2">
	<tr>
	<th>Nombre</th><th>Aforo</th><th>Fecha inicio</th><th>Opciones</th>
	</tr>
	<% for (Evento ele: activos){ %>
		<tr>
		<td><%= ele.getNombre() %></td>
		<td><%= ele.getAforoMaximo() %></td>
		<td><%= ele.getFechaInicio() %></td>
		<td><a href="/eventos/detalle/<%= ele.getIdEvento() %>">Detalle</a></td>
		</tr>
	<%} %>
	</table>
</body>
</html>