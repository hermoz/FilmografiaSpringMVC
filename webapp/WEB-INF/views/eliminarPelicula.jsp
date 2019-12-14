<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eliminar pelicula</title>
</head>
<body>
	<h4>Eliminar pelicula</h4>
	
	<form action="eliminarPelicula.html" method="POST">
		Titulo: <input type="text" name="titulo" value=""><br>
		<br><input type="submit" value="Eliminar">
	<br></form>
	
	<p>${msg }</p>
	
	<form action="listadoPeliculasCompletoYMenu.html" method="POST">
		<button>Volver</button>
	</form>
</body>
</html>