package edu.escuelaing.arep.reproduccion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="reproduccion")
public class reproduccion {

	@Id
	@Column(name="id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name="nombre")
	@Size(min=1,max=100)
	private String nombre;
	
	@Column(name="idcancion")
	@NotNull
	private int idcancion;
	
	
	@Column(name="usuario")
	@NotNull
	@Size(min=1,max=100)
	private String usuario;
	
	public reproduccion() {
		
	}
	
	public reproduccion(String nombre, int idcancion, String usuario) {
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

