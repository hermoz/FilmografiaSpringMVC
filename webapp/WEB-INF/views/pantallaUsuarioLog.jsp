<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn Usuario - Pantalla Principal Usuario</title>
</head>
<body>
	<div>
	<!-- Accedemos a opciones de mantenimiento tras log de usuario satisfactorio -->
	
	<h4>Usuario Correcto - Bienvenido</h4>
	<!--  
				<table style="with: 100%">
				<tr>
					<td>Usuario:${usuario}</td>
				</tr>
				<tr>
					<td>Clave:${clave}</td>
				</tr>
			</table>
-->
<p>Elija la opción que desea realizar</p>
<!-- Botón para acceso al mantenimiento de peliculas -->
	<form action="listadoPeliculasCompletoYMenu.html" method="POST">
		<button>Mantenimiento de peliculas</button>
	</form><br>
	
	<!-- Volver al inicio -->
	<a href="index.html">
		<button>Volver</button></a><br>

	</div>
</body>
</html>