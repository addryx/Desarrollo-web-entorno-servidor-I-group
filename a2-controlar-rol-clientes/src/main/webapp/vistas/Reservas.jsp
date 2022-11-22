<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Reservas</title>
</head>
<<body>	
	<section class="contenedor">
	
		<h1>Mis Reservas</h1>
		
		
		<!-- Si hay reservas, muestro la lista de reservas del usuario -->
		
		<c:if test= "${ listadoReservas != [] }" >
			<table>
			<tr>
				<th>ID RESERVA</th>
				<th>PRECIO EVENTO</th>
				<th>OBSERVACIONES</th>
				<th>CANTIDAD RESERVADA</th>
			</tr>
			<c:forEach items="${listadoReservas}" var="ele" >
				<tr>
					<td>${ele.idReserva}</td>
					<td>${ele.precioVenta} euros.</td>
					<td>${ele.observaciones}</td>
					<td>${ele.cantidad}</td>
				</tr>
			</c:forEach>
			</table>
			
			<p><a href="/clientes">volver a inicio</a></p>
			
		</c:if>
		
		
		<!-- Si no hay reservas, lo indico con un mensaje. -->
		
		<c:if test= "${listadoReservas == []}">
		
			<p>No has realizado todavía ninguna reserva, <a href="/">volver a inicio</a></p>
		
		</c:if>
		
		
		<!-- Muestro un mensaje de si ha sido reservado o no -->
		
		<h3>${ mensajeReserva }</h3>

	</section>

</body>

</html>