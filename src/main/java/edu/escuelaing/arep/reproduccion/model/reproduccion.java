package edu.escuelaing.arep.reproduccion.model;

public class reproduccion {

	private int id;
	private String nombre;
	private int idcancion;
	private String usuario;
	
	public reproduccion() {
		
	}
	
	public reproduccion(int id,String nombre, int idcancion, String usuario) {
		this.id = id;
		this.nombre = nombre;
		this.idcancion = idcancion;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdcancion() {
		return idcancion;
	}

	public void setIdcancion(int idcancion) {
		this.idcancion = idcancion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}

