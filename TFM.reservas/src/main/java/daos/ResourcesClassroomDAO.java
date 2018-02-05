package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.AulaRecursos;

public interface ResourcesClassroomDAO extends JpaRepository<AulaRecursos, Integer> {

	@Query("select t from AulaRecursos t where t.recursos.id = ?1")
	List<AulaRecursos> findbyIDrecurso(int id);

	@Query("select t from AulaRecursos t where t.aula.id = ?1")
	List<AulaRecursos> findbyIDAula(int id);
	
	@Query("select t from AulaRecursos t where t.aula.id = ?1 and t.recursos.id = ?2")
	AulaRecursos findByFK(int idAula, int idRecurso);


}