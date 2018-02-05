package daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Recursos;

public interface ResourcesDAO extends JpaRepository<Recursos, Integer> {

	   @Query("select t from Recursos t where t.nombre = ?1")
	   public Recursos searchByNombre(String nombre);

}
