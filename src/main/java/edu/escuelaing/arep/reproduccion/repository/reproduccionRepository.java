package edu.escuelaing.arep.reproduccion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.escuelaing.arep.reproduccion.model.reproduccion;

public interface reproduccionRepository extends JpaRepository<reproduccion,Integer> {
	
	
	@Query(value="select l.id as id, l.idcancion as idcancion, l.nombre as nombre, l.usuario as usuario from reproduccion l where l.usuario= :usuario and l.nombre= :nombre",nativeQuery = true)
	List<reproduccion> getListaCanciones(String usuario,String nombre);

	@Query(value="select  l.id as id, l.idcancion as idcancion, l.nombre as nombre, l.usuario as usuario from reproduccion l where l.usuario= :usuario",nativeQuery = true)
	List<reproduccion> getListaReproduccionesUser(String usuario);
}
