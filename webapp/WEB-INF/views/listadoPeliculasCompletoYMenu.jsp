<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Listado peliculas</title>
</head>
<body>
	
	<div>

		<!-- Mostramos listado de películas completo de la base de datos -->
		<h5>Listado de películas:</h5>
		<ul>
			<c:forEach items="${pelis}" var="pelicula">
				<li>#${pelicula.id} _ ${pelicula.titulo} _ ${pelicula.director} _${pelicula.fechaEstreno}
				</li>
			</c:forEach>
		</ul>
	</div>
	<br>
	
	<!-- Mostramos menu con resto de opciones-->
	<div>
		<p>Posibles opciones a realizar:
		<p>
	<!-- Dar de alta una película -->
	<a href="altaPelicula.html">
		<button>Dar de alta nueva película</button>
		
	</a>
	<br>
	
	<!-- Modificación de película existente -->
	<form action="modificarPelicula.html" method="POST">
		Indique película a modificar: <input type="text" name="titulo" placeholder="Introduzca titulo">
		<input type="submit">
	</form>
	<br>
	
	<!-- Eliminar película existente -->
	<a href="eliminarPelicula.html">
		<button>Eliminar pelicula</button>
	</a>
	<br>
	<br>
	<a href="index.html">
		<button>Volver</button>
	</a>
	</div>
</body>
</html>