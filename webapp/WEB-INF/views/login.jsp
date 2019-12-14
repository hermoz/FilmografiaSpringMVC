<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn Usuario</title>
</head>
<body>
<p>Insertar datos</p>
<div>
	<h4>Formulario Log In usuario</h4>
	<!-- Una vez accedemos con los datos nos conduce a la pantalla usuario loggeado
	y correspondiente mantenimiento de películas -->
	<form  method="post" action="pantallaUsuarioLog.html">
	
			<table style="with: 100%">
				<tr>
					<td>Usuario</td>
					<td><input type="text" name="usuario" /></td>
				</tr>
				<tr>
					<td>Clave</td>
					<td><input type="password" name="clave" /></td>
				</tr>
			</table>
			<br>
		
		<input type="submit" value="Log In">
	</form>
	<br>
	
	<a href="index.html">
		<button type="button">Volver</button>
	</a>
	</div>
</body>
</html>