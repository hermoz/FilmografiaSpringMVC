<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Filmografia</title>
</head>
<body>
	<br>
	<!-- Mostramos mensaje de error tras no encontrar datos -->
	<div
		style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
		<h3>Se ha producido un error</h3>
		<p>Sentimos indicarle que ese director no se encuentra recogido en nuestra base de datos.Vuelva a intentarlo de nuevo, gracias</p>
		<br>
	</div>
	<!-- Volver al formulario para repetir consulta -->
	<a href="consultarDirector.html">
		<button>Volver</button>
	</a>
</body>
</html>