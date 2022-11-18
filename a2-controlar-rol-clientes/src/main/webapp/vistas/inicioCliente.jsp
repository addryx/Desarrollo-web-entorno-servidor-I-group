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
		List<Evento> lista = (List<Evento>)request.getAttribute("listaEventos");
		List<Evento> activos = (List<Evento>)request.getAttribute("listaActivos");
		List<Evento> destacados = (List<Evento>)request.getAttribute("listaDestacados");
		String mensaje = (String)request.getAttribute("mensaje");
	%>
	
	<p><a href="#">Destacados</a></p>
	<p><a href="#">Activos</a></p>
	
	<h2>Tipo de Eventos</h2>
	
	<p><a href="#">Mis reservas</a></p>
	<p><a href="/clientes/login">Login</a></p>
	<p><a href="#">Registro</a></p>
	<p><a href="#">Salir</a></p>
	
	<h3>Bienvenido ${usuario.nombre}</h3>
	
	<h2>Listado de eventos destacados</h2>
	
	<h3>Mensaje : ${mensaje}</h3>
	
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