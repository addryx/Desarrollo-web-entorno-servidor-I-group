<%@page import="modelo.javabeans.Evento"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dao.EventoDaoImpl"%>
<%@page import="modelo.dao.IntEventoDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
</head>
<body>
	<%
		// Aquí recuperamos la lista del HomeController.
		// Se queda en rojo porque devuelve un Object por lo que hay que hacerle un casting. 
		// Después se queda en amarillo porque te avisa de que el casting puede que no funcione si la variable
		// que metemos como atributo no es la misma del casting hecho. 
		// Lo mismo con el mensaje (casting para pasar de objeto a String)
		List<Evento> lista = (List<Evento>)request.getAttribute("listaEventos");
		List<Evento> activos = (List<Evento>)request.getAttribute("listaActivos");
		String mensaje = (String)request.getAttribute("mensaje");
	%>
	
	<h1>Bienvenidos a Eventos App</h1>
	
	<h2>Opciones Tipo de Eventos</h2>
	
	<p><a href="#">Tipos</a></p>
	<p><a href="#">Eventos</a></p>
	<p><a href="#">Usuarios</a></p>
	<p><a href="#">Eventos/tipo</a></p>
	<p><a href="#">Login</a></p>
	<p><a href="#">Registro</a></p>
	<p><a href="#">Salir</a></p>	
	
	<h2>Listado de eventos activos</h2>
	 
		<h3>Mensajes : <%= (mensaje != null)?mensaje : "" %></h3>
	 
	<h3><a href="FormAltaEvento.jsp">Nuevo Evento</a></h3>
	
	<table border="2">
	<tr>
	<th>Id</th><th>Nombre</th><th>Precio</th><th COLSPAN="3">Opciones</th>
	</tr>
	<% for (Evento ele: activos){ %>
		<tr>
		<td><%= ele.getIdEvento() %></td>
		<td><%= ele.getTipo() %></td>
		<td><%= ele.getPrecioDecimal() %></td>
		<td><a href="Eventos?opcion=editar&id=<%= ele.getIdEvento() %>">Editar Evento</a></td>
		<td><a href="Eventos?opcion=eliminar&id=<%= ele.getIdEvento() %>">Eliminar Evento</a></td>
		<td><a href="Eventos?opcion=cancelar&id=<%= ele.getIdEvento() %>">Cancelar Evento</a></td>
		</tr>
	<%} %>
	</table>
</body>
</html>