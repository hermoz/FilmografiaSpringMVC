<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar pelicula</title>
</head>
<body>
	<h4>Modificar pelicula</h4>
	
	<form action="actualizacionPelicula.html" method="POST">
		Id: <input type="text" name="id" value="${pelicula.id}"> <br>
		Director: <input type="text" name="director" value="${pelicula.director}"> <br>
		Titulo: <input type="text" name="titulo" value="${pelicula.titulo}"> <br>
		Fecha: <input type="text" name="fechaEstreno" value="${pelicula.fechaEstreno}"> <br>
		<input type="submit" value="Modificar">
	</form>
	
	<p>${msg}</p>
	
	<form action="listadoPeliculasCompletoYMenu.html" method="POST">
		<button>Volver</button>
	</form>
</body>
</html>