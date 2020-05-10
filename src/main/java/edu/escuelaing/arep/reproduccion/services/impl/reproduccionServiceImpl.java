package edu.escuelaing.arep.reproduccion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.escuelaing.arep.reproduccion.model.reproduccion;
import edu.escuelaing.arep.reproduccion.repository.reproduccionRepository;
import edu.escuelaing.arep.reproduccion.services.reproduccionService;

@Service
public class reproduccionServiceImpl implements reproduccionService {
	
	@Autowired
	reproduccionRepository listReproduccionRepo;

	@Override
	public void saveListaCancion(reproduccion listareproduccion) {
		listReproduccionRepo.save(listareproduccion);
		
	}

	@Override
	public reproduccion getListaReproduccion(int id) {
		return listReproduccionRepo.findById(id).get();
	}

	@Override
	public List<reproduccion> getListasReproduccionesUser(String usuario) {
		return listReproduccionRepo.getListaReproduccionesUser(usuario);
	}

	@Override
	public List<reproduccion> getListaCanciones(String usuario, String nombre) {
		return listReproduccionRepo.getListaCanciones(usuario,nombre);
	}

}
