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
	
	<form action="Eventos?opcion=alta" method="post"><br>
		IdEvento: <input type="text" name= "idEvento"><br>
		<br>
		Nombre: <input type="text" name= "nombre"><br>
		<br>
		Descripci�n: <input type="text" name= "descripcion" ><br>
		<br>
		Fecha inicio: <input type="date" name= "fechaInicio"><br>
		<br>
		Duraci�n: <input type="text" name= "duracion"><br>
		<br>
		Direcci�n: <input type="text" name= "direccion"><br>
		<br>
		Estado: <input type="text" name= "estado" value= "Activo" readonly="readonly"><br>
		<br>
		Destacado: <input type="radio" name= "destacado" value="S">S<br>
		<br>
		Aforo m�ximo: <input type="text" name= "aforoMaximo"><br>
		<br>
		M�nimo de asistencia: <input type="text" name= "minimoAsistencia"><br>
		<br>
		Precio: <input type="text" name= "precioDecimal"><br>
		<br>
		Tipo: <select name= "tipo">
				<option value= 1>Concierto</option>
				<option value= 2>Despedida</option>
				<option value= 3>Cumplea�os</option>
				<option value= 4>Boda</option></select>
		<br>
		<br>
		<p><input type="submit" value="Enviar el formulario"></p>
	</form>

</body>

</html>