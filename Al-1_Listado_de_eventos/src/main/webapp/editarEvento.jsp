<%@page import="modelo.javabeans.Evento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar evento</title>
</head>
<body>
	<%
	Evento evento = (Evento)request.getAttribute("evento");
	%>
	<p>idEvento: <%=evento.getIdEvento()%></p><br>
	<p>Nombre: <%=evento.getNombre()%></p><br>
	<p>Descripci�n: <%=evento.getDescripcion()%></p><br>
	<p>	Fecha inicio: <%=evento.getFechaInicio()%></p><br>
	<p>	Duraci�n: <%=evento.getDuracion()%></p><br>
	<p>	Direcci�n: <%=evento.getDireccion()%></p><br>
	<p>	Estado: <%=evento.getEstado()%></p><br>
	<p>	Destacado: <%=evento.getDestacado()%></p><br>
	<p>	Aforo m�ximo: <%=evento.getAforoMaximo()%></p><br>
	<p>	Minimo asistencia: <%=evento.getMinimoAsistencia()%></p><br>
	<p>	Precio:<%=evento.getPrecioDecimal()%></p><br>
	<p>	Tipo: <%=evento.getTipo()%></p><br>
</body>
</html>