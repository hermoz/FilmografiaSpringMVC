package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LogIn {
	
	@Id
	private String usuario;
	private String clave;

	public LogIn (String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}
	
	public String getusuario() {
		return usuario;
	}

	public void setusuario(String usuario) {
		this.usuario = usuario;
	}

	public String getclave() {
		return clave;
	}

	public void setclave(String clave) {
		this.clave = clave;
	}
	@Override
	public String toString() {
		return "Login [usuario=" + usuario + ", clave=" + clave + "]";
	}

}