package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Horario;

public interface TimeDAO extends JpaRepository<Horario, Integer> {

//	@Query("ALTER TABLE personal t  AUTO_INCREMENT = 1")
//	void deleteKey();

}
