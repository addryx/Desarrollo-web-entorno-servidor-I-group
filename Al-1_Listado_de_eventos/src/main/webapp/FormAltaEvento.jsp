<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMULARIO DE ALTA DE EVENTO</h1>
	
	<form action= "evento?opcion=alta" method="post">
		<p><input type="text" name= "idEvento">IdEvento</p>
		<p><input type="text" name= "nombre">Nombre</p>
		<p><input type="text" name= "descripcion">Descripcion</p>
		<p><input type="text" name= "fechaInicio">Fecha Inicio</p>
		<p><input type="text" name= "duracion">duracion</p>
		<p><input type="text" name= "direccion">duracion</p>
		<p><input type="text" name= "direccion">duracion</p>
		<p><input type="text" name= "estado">estado</p>
		<p><input type="text" name= "destacado" placeholder="Escribe una S si el evento es destacado">destacado</p>
		<p><input type="text" name= "aforoMaximo">Aforo Maximo</p>
		<p><input type="text" name= "precio">precio</p>
		<p><input type="text" name= "tipo">Tipo</p>
		
		
		<p><input type="submit" value= "Enviar"></p>
	</form>

</body>

</html>