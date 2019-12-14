<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>>Consultar director</title>
</head>
<body>
	
	<form action="listadoPeliculasDir.html" method="POST">
		<input type="text" name="director" placeholder="Introduzca nombre director cine">
		<input type="submit" value="Consultar"><br>
	</form>
	<br>
	<a href="index.html">
		<button type="button" value="Volver">Volver</button>
	</a>
	
</body>
</html>