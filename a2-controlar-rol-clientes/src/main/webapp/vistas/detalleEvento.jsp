<%@page import="java.util.List"%>
<%@page import="com.edix.clientes.modelo.beans.Evento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar evento</title>
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
	
	<p>Reserva: </p>
	<p>Usuario: </p>
	<p>Evento: </p>
	<form action="" method="post">
		<input type="number" name= "cantidad">
		<input type="submit" value="Enviar">
	</form>
	<img src="">
</body>
</html>