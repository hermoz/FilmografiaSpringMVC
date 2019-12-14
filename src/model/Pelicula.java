package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pelicula")
public class Pelicula {
	
	
	/**
	 * Declaramos los atributos correspondientes con los campos
	 * definidos en la base de datos "cine"
	 */
	@Id
	public String id;
	public String director;
	public String titulo;
	public String fechaEstreno;
	
	
	public Pelicula(String id, String director, String titulo, String fechaEstreno) {
		super();
		this.id = id;
		this.director = director;
		this.titulo = titulo;
		this.fechaEstreno = fechaEstreno;
	}
	
	public Pelicula() {
		super();
	}

	/**
	 * Definimos m�todos getter y setters para posteriores accesos a par�metros
	 */
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getFechaEstreno() {
		return fechaEstreno;
	}


	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", titulo=" + titulo + ", fecha="
				+ fechaEstreno + "]";
	}	
}