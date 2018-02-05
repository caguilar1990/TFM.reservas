package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Personal;

public interface PersonalDAO  extends JpaRepository<Personal, Integer>  {
	
	   @Query("select t from Personal t where t.permisos.id = 3")
	   public List<Personal> findMaestroLaboratorio();
	   
	   @Query("select t from Personal t where t.username = ?1")
	   public Personal searchByUsername(String username);

}
