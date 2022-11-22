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

	<%
	Evento evento = (Evento) request.getAttribute("evento");
	%>
	<p>
		Nombre: 
		<%=evento.getNombre()%></p>
	<p>
		Descripci�n:
		<%=evento.getDescripcion()%></p>
	<p>
		Direcci�n:
		<%=evento.getDireccion()%></p>
	<p>
		Fecha inicio:
		<%=evento.getFechaInicio()%></p>
	<p>
		Duraci�n:
		<%=evento.getDuracion()%></p>
	<p>
		Aforo m�ximo:
		<%=evento.getAforoMaximo()%></p>
	<p>
		Minimo asistencia:
		<%=evento.getMinimoAsistencia()%></p>
	<p>
		Precio:<%=evento.getPrecioDecimal()%></p>

	<section>

		<!-- Para indicar las entradas restantes, cojo el total de plazas y le resto las plazas reservadas -->

		<p>Quedan: ${ evento.aforoMaximo - cantidad } entradas.</p>

	</section>

	<h3>Reserva:</h3>
	<p>${mensaje}</p>
	<form action="/clientes/reservar/<%=evento.getIdEvento()%>" method="post">
		Cantidad: 
		<input type="number" name="cantidad"><br>
		<input type="submit" value="Reservar">
	</form>

</body>
</html>