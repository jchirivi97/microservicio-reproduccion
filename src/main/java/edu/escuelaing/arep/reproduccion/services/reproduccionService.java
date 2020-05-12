package edu.escuelaing.arep.reproduccion.services;

import java.util.List;

import edu.escuelaing.arep.reproduccion.model.reproduccion;


public interface reproduccionService {
	

	void saveListaCancion(int id,String nombre,int idcancion,String usuario);
		
	reproduccion getListaReproduccion(int id); 	
	
	List<reproduccion> getListasReproduccionesUser(String usuario);
	
	List<reproduccion> getListaCanciones(String usuario,String nombre);

}
