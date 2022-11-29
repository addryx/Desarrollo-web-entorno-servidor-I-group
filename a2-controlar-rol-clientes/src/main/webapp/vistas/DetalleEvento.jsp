<%@page import="com.edix.clientes.modelo.beans.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="com.edix.clientes.modelo.beans.Evento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles del evento</title>
</head>
<body>
	<h1>Detalle del Evento Seleccionado</h1>

	<p>
		Nombre: 
		${evento.nombre}</p>
	<p>
		Descripción:
		${evento.descripcion}</p>
	<p>
		Dirección:
		${evento.direccion}</p>
	<p>
		Fecha inicio:
		${evento.fechaInicio }</p>
	<p>
		Duración:
		${evento.duracion}</p>
	<p>
		Aforo máximo:
		${evento.aforoMaximo}</p>
	<p>
		Minimo asistencia:
		${evento.minimoAsistencia}</p>
	<p>
		Precio:
		${evento.precioDecimal}</p>

	<section>
		<!-- Para indicar las entradas restantes, cojo el total de plazas y le resto las plazas reservadas -->
		<p>Quedan: ${quedan} entradas.</p>
	</section>

	<h3>Reserva: ${totalReservas}</h3>
	
	<p>${mensaje}</p>
	
	<form action="/clientes/reservar/${evento.idEvento}" method="post">
		Cantidad: 
		<input type="number" name="cantidad" min=1 max=10>
		<input type="submit" value="Reservar">
	</form>

</body>
</html>