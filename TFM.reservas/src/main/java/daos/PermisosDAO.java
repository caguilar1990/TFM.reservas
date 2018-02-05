package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Permisos;


public interface PermisosDAO extends JpaRepository<Permisos, Integer> {

}
