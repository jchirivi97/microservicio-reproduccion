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
@RequestMapping(value="/reproduccion")
public class reproduccionController {

	@Autowired
	reproduccionService listServ;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> saveLista(int id,String nombre,int idcancion,String usuario){
		listServ.saveListaCancion(id, nombre, idcancion, usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/{id}")
	public ResponseEntity<?> getListaReproduccion(@PathVariable("id") int id){
		System.out.println("entro a Lista por id");
		reproduccion list = listServ.getListaReproduccion(id);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	} 
	
	@RequestMapping(method = RequestMethod.GET,path="/user/{usuario}")
	public ResponseEntity<?> getListaUser(@PathVariable("usuario") String usuario){
		List<reproduccion> list = listServ.getListasReproduccionesUser(usuario);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/{usuario}/{nombre}")
	public ResponseEntity<?> getListaCanciones(@PathVariable("usuario") String usuario,@PathVariable("nombre") String nombre){
		System.out.println("entro a Lista por usuario y nombre");
		List<reproduccion> list = listServ.getListaCanciones(usuario,nombre);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
	
}
