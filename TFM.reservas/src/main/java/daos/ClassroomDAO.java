package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Aula;



public interface ClassroomDAO extends JpaRepository<Aula, Integer> {



	@Query("select t from Aula t where t.personal.id = ?1")
	List<Aula> findbyPersonal(int id);
	
	   @Query("select t from Aula t where t.referencia = ?1")
	   public Aula searchByReferencia(int username);

//	@Query("ALTER TABLE personal t  AUTO_INCREMENT = 1")
//	void deleteKey();
	




}