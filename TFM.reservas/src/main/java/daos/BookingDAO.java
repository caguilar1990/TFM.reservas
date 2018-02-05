package daos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import entities.Reservas;

public interface BookingDAO extends JpaRepository<Reservas, Integer> {
	
	@Query("SELECT  DISTINCT  t from Reservas t WHERE t.id.fechaReserva = ?1 ")
	List<Reservas> findClassroomsBookingByDate(Date fecha);
	
	@Query("SELECT  DISTINCT  t from Reservas t WHERE t.id.fechaReserva >= ?1  and t.estado = ?2")
	List<Reservas> 	findClassroomsBookingByDateAndState(Date fecha , Boolean estado);
	
	@Query("SELECT  t from Reservas t WHERE t.id.idPersonal = ?1  and t.id.idAula = ?2 and t.id.fechaReserva = ?3 and t.id.idHorario = ?4 ")
	Reservas 	findByID(int idPersonal, int idAula, Date fechaReserva, int idHorario);

	@Query("SELECT  t from Reservas t WHERE t.id.idPersonal = ?1 ")
	List<Reservas> findByPersonal(int idPersonal);

	@Query("SELECT  DISTINCT  t from Reservas t WHERE t.id.fechaReserva >= ?1 and t.id.idPersonal =?2 order by t.id.fechaReserva ASC")
	List<Reservas> findClassroomsBookingByDate(Date fecha, int idPersonal);

	@Query("SELECT  DISTINCT  t from Reservas t WHERE t.id.fechaReserva >= ?1  and t.estado = ?2 and t.id.idPersonal =?3 order by t.id.fechaReserva ASC")
	List<Reservas> findClassroomsBookingByDateAndState(Date fecha, Boolean estado, int idPersonal);

	//Maestro de Laboratorio
	@Query("SELECT  DISTINCT  t from Reservas t WHERE t.id.fechaReserva = ?1 and t.aula.personal.id =?2 order by t.id.fechaReserva ASC")
	List<Reservas> findClassroomsBookingByDateMaster(Date fecha, int responsable);
	
	@Query("SELECT  DISTINCT  t from Reservas t WHERE t.id.fechaReserva = ?1  and t.estado = ?2  and t.aula.personal.id =?3 order by t.id.fechaReserva ASC")
	List<Reservas> findClassroomsBookingByDateAndStateMaster(Date fecha, Boolean estado, int responsable);

	@Query("SELECT  DISTINCT  t from Reservas t WHERE  t.aula.personal.id =?1")
	List<Reservas> getByMaster(int idMaestro);

	@Query("SELECT  DISTINCT  t from Reservas t WHERE  t.aula.id =?1")
	List<Reservas> searchByClass (int idAula);
}
