package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BBDD;
import model.Pelicula;

@Controller
public class controladorUnicoFilm {

	BBDD conexion;
	String next = null;

	/**
	 * @RequestMappingla anotación se utiliza para asignar solicitudes web a los
	 *                   métodos de Spring Controller. Esta anotación asigna
	 *                   solicitudes HTTP a métodos de controlador de controladores
	 *                   MVC y REST.
	 */

	// Mostramos información general de funcionamiento de app
	@RequestMapping("/info")
	public ModelAndView info() {
		return new ModelAndView("info");
	}

	// Consulta de datos de directores por nombre
	@RequestMapping("/consultarDirector")
	public ModelAndView consultarDirector() {
		return new ModelAndView("consultarDirector");
	}

	// Log in de usuario para acceso a mantenimiento de la app
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	//mostramos listado de peliculas correspondientes al director solicitado
	@PostMapping("/listadoPeliculasDir")
	public ModelAndView listadoPeliculasDir(HttpServletRequest request) throws SQLException, ClassNotFoundException {

		conexion = new BBDD();
		String director = request.getParameter("director");
		List<Pelicula> peliculas = conexion.peliculasDirector(director);

		if (peliculas.size() != 0) {
			request.setAttribute("lista", peliculas);
			next = "listadoPeliculasDir";
		} else {
			next = "errorDirectorNoExiste";
		}

		return new ModelAndView(next, "lista", peliculas);
	}

	// Acceso al menu de mantenimiento de peliculas con diversas opciones para la
	// creación, modificación o eliminación
	@PostMapping("/listadoPeliculasCompletoYMenu")
	public ModelAndView obtenerPeliculas(HttpServletRequest request) throws SQLException, ClassNotFoundException {

		conexion = new BBDD();
		List<Pelicula> peliculas = conexion.obtenerPeliculas();

		request.setAttribute("pelis", peliculas);

		next = "listadoPeliculasCompletoYMenu";

		return new ModelAndView(next, "pelis", peliculas);
	}
	
	//Pantalla de acceso principal tras acceso de usuario
	@PostMapping("/pantallaUsuarioLog")
	public ModelAndView loginUser(HttpServletRequest request) throws SQLException, ClassNotFoundException {

		conexion = new BBDD();

		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		int numero = conexion.usuariosBBDD(usuario, clave);
		if (numero > 0) {
			request.setAttribute("msg", "Todo correcto");
			next = "pantallaUsuarioLog";
		} else {
			next = "errorUsuarioNoExiste";
		}

		return new ModelAndView(next);
	}

	
	@GetMapping("/listadoPeliculasCompletoYMenu")
	public ModelAndView mantPeli() {
		return new ModelAndView("listadoPeliculasCompletoYMenu");
	}

	//Creación de nueva entrada en la base de datos
	//GET de datos introducimos en el formulario
	@GetMapping("/altaPelicula")
	public ModelAndView altaPelicula() {
		return new ModelAndView("altaPelicula");
	}

	//POST con datos para la creación de nueva entrada
	@PostMapping("/altaPelicula")
	public ModelAndView altaPelicula(HttpServletRequest request) throws SQLException, ClassNotFoundException {

		conexion = new BBDD();

		String id = request.getParameter("id");
		String director = request.getParameter("director");
		String titulo = request.getParameter("titulo");
		String fechaEstreno = request.getParameter("fechaEstreno");
		
		try {
			int registro = conexion.crearPelicula(id, director, titulo, fechaEstreno);
			if (registro > 0) {
				request.setAttribute("msg", "Pelicula creada correctamente");
				next = "altaPelicula";
			}

		} catch (Exception e) {
			request.setAttribute("msg", "La pelicula no ha sido creada");
			next = "altaPelicula";
		}

		return new ModelAndView(next);
	}




	@PostMapping("/modificarPelicula")
	public ModelAndView modificarPelicula(HttpServletRequest request) throws SQLException, ClassNotFoundException {

		conexion = new BBDD();
		Pelicula pe = null;

		try {

			pe = conexion.obtenerPelicula(request.getParameter("titulo"));

			next = "modificarPelicula";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView(next, "pelicula", pe);
	}
	

	@PostMapping("/actualizacionPelicula")
	public ModelAndView actualizacionPeli(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		String id = request.getParameter("id");
		String director = request.getParameter("director");
		String titulo = request.getParameter("titulo");
		String fechaEstreno = request.getParameter("fechaEstreno");

		Pelicula pe = new Pelicula(id, director, titulo, fechaEstreno);

		try {

			conexion.modificarPelicula(pe);

			int registro = conexion.modificarPelicula(pe);

			if (registro < 0) {
				request.setAttribute("msg", "La pelicula no se ha actualizado");
				next = "modificarPelicula";
			}

		} catch (Exception e) {

			request.setAttribute("msg", "La pelicula no se ha actualizado");
			next = "modificarPelicula";
		}
		return new ModelAndView(next);
	}
	
	@GetMapping("eliminarPelicula")
	public ModelAndView eliminarPelicula() {
		return new ModelAndView("eliminarPelicula");
	}

	
	@PostMapping("/eliminarPelicula")
	public ModelAndView eliminarPeli(HttpServletRequest request) throws SQLException, ClassNotFoundException {

		conexion = new BBDD();

		String titulo = request.getParameter("titulo");

		try {
			int registro = conexion.eliminarPelicula(titulo);
			if (registro > 0) {
				request.setAttribute("msg", "La pelicula ha sido eliminada");
				next = "eliminarPelicula";
			}

		} catch (Exception e) {

			request.setAttribute("msg", "La pelicula no ha sido eliminada");
			next = "eliminarPelicula";
		}

		return new ModelAndView(next);
	}

}
