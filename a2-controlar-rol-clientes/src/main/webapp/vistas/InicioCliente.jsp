<%@page import="com.edix.clientes.modelo.beans.Evento"%>
<%@page import="java.util.List"%>
<%@page import="com.edix.clientes.modelo.repository.EventoDaoImpl"%>
<%@page import="com.edix.clientes.modelo.repository.IntEventoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista cliente</title>
</head>
<body>
	<%
		List<Evento> destacados = (List<Evento>)request.getAttribute("listaDestacados");
	%>
	
	<p><a href="/clientes/destacados">Destacados</a></p>
	<p><a href="/clientes/activos">Activos</a></p>
	
	<h2>Tipo de Eventos</h2>
	
	<p><a href="/reservas">Mis reservas</a></p>
	<p><a href="/clientes/cerrarSesion">Salir</a></p>
	
	<h3>Bienvenido ${sesionUsuario.username}</h3>
	
	<h2>Listado de eventos destacados</h2>
	
	<h3>${mensaje}</h3>
	
	<table border="2">
	<tr>
	<th>Nombre</th><th>Aforo</th><th>Fecha inicio</th><th>Opciones</th>
	</tr>
	<% for (Evento ele: destacados){ %>
		<tr>
		<td><%= ele.getNombre() %></td>
		<td><%= ele.getAforoMaximo() %></td>
		<td><%= ele.getFechaInicio() %></td>
		<td><a href="/clientes/detalle/<%= ele.getIdEvento() %>">Detalle</a></td>
		</tr>
	<%} %>
	</table>
</body>
</html>