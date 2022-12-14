<%@page import="com.edix.clientes.modelo.beans.Evento"%>
<%@page import="java.util.List"%>
<%@page import="com.edix.clientes.modelo.repository.EventoDaoImpl"%>
<%@page import="com.edix.clientes.modelo.repository.IntEventoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista cliente</title>
</head>
<body>
	<p>
		<a href="/clientes/destacados">Destacados</a>
	</p>
	<p>
		<a href="/clientes/activos">Activos</a>
	</p>

	<h2>Tipo de Eventos</h2>

	<p>
		<a href="#">Mis reservas</a>
	</p>
	<p>
		<a href="/clientes/login">Login</a>
	</p>
	<p>
		<a href="#">Registro</a>
	</p>
	<p>
		<a href="/clientes/cerrarSesion">Salir</a>
	</p>

	<h3>Bienvenido ${sesionUsuario.username}</h3>

	<h2>Listado de eventos activos</h2>

	<h3>${mensaje}</h3>

	<table border="2">
		<tr>
			<th>Nombre</th>
			<th>Aforo</th>
			<th>Fecha inicio</th>
			<th>Opciones</th>
		</tr>
		<c:forEach var="ele" items="${listaActivos}">
			<tr>
				<td>${ele.nombre}</td>
				<td>${ele.aforoMaximo}</td>
				<td>${ele.fechaInicio}</td>
				<td><a href="/clientes/detalle/${ele.idEvento}">Detalle</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>