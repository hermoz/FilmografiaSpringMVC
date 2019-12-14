<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar pelicula</title>
</head>
<body>
	<p>Datos nuevo a introducir en base de datos:</p>
	
	<form action="altaPelicula.html" method="POST">
	
		Id: <input type="text" name="id" value=""><br>
		Director: <input type="text" name="director" value=""><br>
		Título: <input type="text" name="titulo" value=""><br>
		Fecha Estreno: <input type="text" name="fechaEstreno" value=""><br>

		<input type="submit" value="Crear">
	</form>
	
	<p>${msg}</p>
	
	<form action="listadoPeliculasCompletoYMenu.html" method="POST">
		<button>Volver</button>
	</form>
</body>
</html>