package edu.escuelaing.arep.reproduccion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.arep.reproduccion.model.reproduccion;
import edu.escuelaing.arep.reproduccion.services.reproduccionService;

@RestController
@RequestMapping(value="reproduccion")
public class reproduccionController {

	@Autowired
	reproduccionService listServ;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<reproduccion> saveLista(reproduccion lista){
		listServ.saveListaCancion(lista);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/{id}")
	public ResponseEntity<reproduccion> getListaReproduccion(@PathVariable("id") int id){
		reproduccion list = listServ.getListaReproduccion(id);
		return ResponseEntity.ok(list);
	} 
	
	@RequestMapping(method = RequestMethod.GET,path="/user/{usuario}")
	public ResponseEntity<List<reproduccion>> getListaUser(@PathVariable("usuario") String usuario){
		List<reproduccion> list = listServ.getListasReproduccionesUser(usuario);
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/canciones/{usuario}/{nombre}")
	public List<reproduccion> getListaCanciones(@PathVariable("usuario") String usuario,@PathVariable("nombre") String nombre){
		List<reproduccion> list = listServ.getListaCanciones(usuario,nombre);
		return list;
	}
	
	
}
