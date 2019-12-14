<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado peliculas</title>
</head>
<body>
<div>
	<style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: center;">
		<h5>Director: ${director}</h5>
		<p>Lista de Películas:</p>
		<ul>
			<c:forEach items="${lista}" var="pelicula">
				<li>#${pelicula.id}
				 _ ${pelicula.titulo} 
				 _ ${pelicula.director}		 
				 </li>
			</c:forEach>
		</ul>
	</div>
	
	<br>
	
	<br><a href="consultarDirector.html">
		<button>Volver a consultar</button>
	</a><br>
	
	<br><a href="index.html">
		<button class="btn btn-warning">Inicio</button>
	</a>
	
</body>
</html>