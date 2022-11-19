<%@page import="com.edix.clientes.modelo.beans.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="com.edix.clientes.modelo.beans.Evento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles del evento</title>
</head>
<body>
	<h1>Detalle del Evento Seleccionado</h1>
	
	<%Evento evento = (Evento)request.getAttribute("evento");%>
	<p>Nombre: ${evento.nombre}</p>
	<p>Descripción: <%=evento.getDescripcion()%></p>
	<p>Dirección: <%=evento.getDireccion()%></p>
	<p>Fecha inicio: <%=evento.getFechaInicio()%></p>
	<p>Duración: <%=evento.getDuracion()%></p>
	<p>Aforo máximo: <%=evento.getAforoMaximo()%></p>
	<p>Minimo asistencia: <%=evento.getMinimoAsistencia()%></p>
	<p>Precio:<%=evento.getPrecioDecimal()%></p>
	
	<p>Quedan: </p>
	
	<h3>Reserva: </h3>
	<p>${mensaje}</p>
	<form action="/clientes/reserva/<%=evento.getIdEvento()%>" method="post">
		Usuario: <input type="text" name= "usuario" value="${sesionUsuario.username}" readonly=»readonly»><br>
		Evento: <input type="text" name= "evento" value="${evento.nombre}" readonly=»readonly»><br>
		Precio unitario: <input type="number" name= "precioVenta" value="${evento.precioDecimal}" readonly=»readonly»><br>
		Observaciones: <textarea type="textarea" name= "observaciones" autofocus maxlength=90></textarea><br>
		Cantidad: <input type="number" name= "cantidad"><br>
		<input type="submit" value="Reservar">
	</form>
</body>
</html>