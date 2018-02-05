package api;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.BookingController;
import entities.Aula;
import entities.Reservas;

@RestController
@RequestMapping(Uris.RESERVAS)
public class BookingRest {

	private Logger logger = LogManager.getLogger(BookingRest.class.getName());

	public BookingController bookingController;

	@Autowired
	public void setBookingController(BookingController bookingController) {
		this.bookingController = bookingController;
	}

	
	

	@RequestMapping(method = RequestMethod.POST)
	public void addBooking(@RequestBody Reservas booking) {

		this.bookingController.addBooking(booking);
	}

	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Reservas> getAll() {
		List<Reservas> bookingList = bookingController.getAll();
		return bookingList;
	}

	@RequestMapping(method = RequestMethod.GET, value = Uris.FECHA + Uris.HORARIO_LIST + Uris.RECURSOS_LIST)
	public List<Aula> findClassroomsfree(@PathVariable(value = "fecha") Date fecha,@PathVariable(value = "horario") String horario, @PathVariable(value = "recursos") String recursos) {
		return bookingController.findClassroomsfree(fecha, horario, recursos);
	}

	@RequestMapping(method = RequestMethod.GET, value = Uris.FECHA +Uris.PERSONAL+Uris.PERSONAL_ID)
	public List<Reservas> findClassroomsBookingByDate(@PathVariable(value = "fecha") Date fecha,@PathVariable(value = "idPersonal") int idPersonal) {
		return bookingController.findClassroomsBookingByDate(fecha,idPersonal);
	}

	
	@RequestMapping(method = RequestMethod.GET, value = Uris.FECHA + Uris.ESTADO +Uris.PERSONAL +Uris.PERSONAL_ID)
	public List<Reservas> findClassroomsBookingByDateAndState(@PathVariable(value = "fecha") Date fecha , @PathVariable(value = "estado") Boolean estado ,@PathVariable(value = "idPersonal") int idPersonal) {
		logger.debug("findClassroomsBookingByDateAndState()");
		return bookingController.findClassroomsBookingByDateAndState(fecha,estado,idPersonal);
	}

	@RequestMapping(method = RequestMethod.DELETE , value = Uris.PERSONAL_ID + Uris.AULA_ID +Uris.FECHA + Uris.HORARIO_ID)
	public void removeBooking(@PathVariable(value = "idPersonal") int personalId, @PathVariable(value = "idAula") int idAula, @PathVariable(value = "fecha") Date fecha,@PathVariable(value = "idHorario") int idHorario ) {
		logger.debug("removeBooking()");
		this.bookingController.removeBooking(personalId,idAula,fecha,idHorario);
	}

	@RequestMapping(method = RequestMethod.PUT , value = Uris.PERSONAL_ID + Uris.AULA_ID +Uris.FECHA + Uris.HORARIO_ID)
	public void acceptBooking(@PathVariable(value = "idPersonal") int personalId, @PathVariable(value = "idAula") int idAula, @PathVariable(value = "fecha") Date fecha,@PathVariable(value = "idHorario") int idHorario) {
		logger.debug("acceptBooking()");
		this.bookingController.acceptBooking(personalId,idAula,fecha,idHorario);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value =Uris.PERSONAL +Uris.PERSONAL_ID)
	public List<Reservas> findByPersonal(@PathVariable(value = "idPersonal") int idPersonal) {
		return bookingController.findByPersonal(idPersonal);
	}
	
	//Busqueda de Reservas por Maestro de Laboratorio
	
	@RequestMapping(method = RequestMethod.GET, value = Uris.FECHA +Uris.PERSONAL_MAESTROS+Uris.ID)
	public List<Reservas> findClassroomsBookingByDateMaster(@PathVariable(value = "fecha") Date fecha,@PathVariable(value = "id") int idMaestro) {
		return bookingController.findClassroomsBookingByDateMaster(fecha,idMaestro);
	}

	
	@RequestMapping(method = RequestMethod.GET, value = Uris.FECHA + Uris.ESTADO +Uris.PERSONAL_MAESTROS+Uris.ID)
	public List<Reservas> findClassroomsBookingByDateAndStateMaster(@PathVariable(value = "fecha") Date fecha , @PathVariable(value = "estado") Boolean estado ,@PathVariable(value = "id") int idMaestro) {

		return bookingController.findClassroomsBookingByDateAndStateMaster(fecha,estado,idMaestro);
	}
	

	@RequestMapping(method = RequestMethod.GET, value = Uris.PERSONAL_MAESTROS+Uris.ID)
	public List<Reservas> getByMaster(@PathVariable(value = "id") int idMaestro) {
		return bookingController.getByMaster(idMaestro);
	}

	
	@RequestMapping(method = RequestMethod.GET, value = Uris.AULA_ID  + Uris.FECHA_INICIAL + Uris.FECHA_FINAL + Uris.DIAS +Uris.HORARIO_LIST + Uris.PERSONAL_ID + Uris.DESCRIPCION)
	public boolean addBookingCustomize(@PathVariable(value = "idAula") int idAula,@PathVariable(value = "fechaInicial") Date fechaInicial,@PathVariable(value = "fechaFinal") Date fechaFinal ,@PathVariable(value = "dias") String dias ,@PathVariable(value = "horario") String horario, 
			@PathVariable(value = "idPersonal") int idPersonal ,@PathVariable(value = "descripcion") String descripcion  ) {

		return this.bookingController.addBookingCustomize(idAula,fechaInicial,fechaFinal,dias,horario,idPersonal,descripcion);
	}

}
