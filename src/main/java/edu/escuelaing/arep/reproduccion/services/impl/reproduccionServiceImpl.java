package edu.escuelaing.arep.reproduccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arep.reproduccion.model.reproduccion;
import edu.escuelaing.arep.reproduccion.repository.reproduccionRepository;
import edu.escuelaing.arep.reproduccion.services.reproduccionService;

@Service
public class reproduccionServiceImpl implements reproduccionService {
	
	reproduccionRepository listReproduccionRepo;
	
	private void Bdata() {
		listReproduccionRepo = new reproduccionRepository();
	}

	@Override
	public void saveListaCancion(int id, String nombre, int idcancion, String usuario) {
		Bdata();
		listReproduccionRepo.saveReproduccion(id, nombre, idcancion, usuario);		
	}

	@Override
	public reproduccion getListaReproduccion(int id) {
		Bdata();
		return listReproduccionRepo.getReproduccion(id);
	}

	@Override
	public List<reproduccion> getListasReproduccionesUser(String usuario) {
		Bdata();
		return listReproduccionRepo.getListaReproduccionesUser(usuario);
	}

	@Override
	public List<reproduccion> getListaCanciones(String usuario, String nombre) {
		Bdata();
		return listReproduccionRepo.getListaCanciones(usuario, nombre);
	}

}
