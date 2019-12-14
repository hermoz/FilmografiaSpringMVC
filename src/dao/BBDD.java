package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Pelicula;
import model.LogIn;

public class BBDD {

	Connection conn;
	Statement stmt;
	ResultSet r1;
	int r2;

	//Conexion con base de datos
	public BBDD() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "");
	}
	
	//Obtencion de listado de peliculas completo
	public List<Pelicula> obtenerPeliculas() throws SQLException {
		
		stmt = conn.createStatement();		
		List<Pelicula> peliculas = new ArrayList<Pelicula>();	
		String sql = "SELECT * FROM pelicula";		
		r1 = stmt.executeQuery(sql);
		
		while(r1.next()) {
			peliculas.add(new Pelicula(r1.getString(1), r1.getString(2), r1.getString(3), r1.getString(4)));
		}
		
		return peliculas;		
	}

	//Obtención de listado de peliculas segun director
	public List<Pelicula> peliculasDirector(String director) throws SQLException {	
		stmt = conn.createStatement();
		List<Pelicula> lista = new ArrayList<Pelicula>();

		String sql = "select * from pelicula where director = '" + director + "'";
		r1 = stmt.executeQuery(sql);

		while (r1.next()) {
			lista.add(new Pelicula(r1.getString(1), r1.getString(2), r1.getString(3), r1.getString(4)));		
		}

		return lista;

	}

	//obtencion de usuarios de la base de datos
	public int usuariosBBDD(String usuario, String clave) throws SQLException {
		
		int resultado = 0;
		stmt = conn.createStatement();	
		String sql = "SELECT COUNT(*) FROM login WHERE usuario = '" + usuario + "' and clave = '"+clave+"'";

		r1 = stmt.executeQuery(sql);
		
		if(r1.next()) {
			resultado = r1.getInt(1);
		}

		return resultado;
			
	}
	
	//Busqueda de usuario en la base de datos
	public List<LogIn> getUsernamePassword(String usuario, String clave) throws SQLException {
		List <LogIn> usuarios = new ArrayList<LogIn>(); 		
		stmt = conn.createStatement();
		
		String sql = "select usuario, clave from login where usuario = '" + usuario+"' and clave= '"+clave+"'";	
		r1 = stmt.executeQuery(sql);
		
		while(r1.next()) {
			usuarios.add(new LogIn(r1.getString(1), r1.getString(2)));
		}
		
		return usuarios;
		
	}
	
	//Obtención de listado de peliculas de la base de datos
	public List<Pelicula> peliculas() throws SQLException {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();	
		stmt = conn.createStatement();
		
		String sql = "SELECT * FROM pelicula";	
		r1 = stmt.executeQuery(sql);
		
		while(r1.next()) {
			peliculas.add(new Pelicula(r1.getString(1), r1.getString(2), r1.getString(3), r1.getString(4)));
		}
		
		return peliculas;	
	}
	
	//Creación de nueva pelicula en la base de datos
	public int crearPelicula(String id, String director, String titulo, String fechaEstreno) throws SQLException {
		int dato;
		stmt = conn.createStatement();	
		String sql = "insert into pelicula (id, director, titulo, fecha) VALUES ('"+id+"','"+director+"','"+titulo+"','"+fechaEstreno+"')";
	
		dato = r2 = stmt.executeUpdate(sql);
		
		return dato;
	}
	
	//Obtencion de pelicula de base de datos
	public Pelicula obtenerPelicula(String titulo) throws SQLException {
		Pelicula pelicula = null;
		String consulta = "select * from pelicula where titulo like '"+titulo+"'";
		stmt = conn.createStatement();
		r1 = stmt.executeQuery(consulta);
		
		while(r1.next()) {
			pelicula = new Pelicula (r1.getString(1), r1.getString(2), r1.getString(3), r1.getString(4));
		}
		
		return pelicula;
	}
	
	//Eliminacion pelicula existente en la base de datos
	public int eliminarPelicula(String titulo) throws SQLException {	
		int dato;		
		stmt = conn.createStatement();		
		String sql = "DELETE FROM pelicula WHERE titulo = '" +titulo+"'";	
		dato = r2 = stmt.executeUpdate(sql);
		
		return dato;
	}
	

	//Modificación de pelicula existente en la base de datos
	public int modificarPelicula(Pelicula peli) throws SQLException {
		int dato;		
		stmt = conn.createStatement();		
		String sql = "UPDATE pelicula SET id = '"+peli.id+"', director = '"+peli.director+"', titulo = '"+peli.titulo+"', fecha = '"+peli.fechaEstreno+"' WHERE titulo = '"+peli.titulo+"';";		
		dato = stmt.executeUpdate(sql);
		
		return dato;
	}
	
}