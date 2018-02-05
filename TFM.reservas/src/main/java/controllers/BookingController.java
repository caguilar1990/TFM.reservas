package controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import daos.BookingDAO;
import daos.ClassroomDAO;
import daos.PersonalDAO;
import daos.TimeDAO;
import entities.Aula;
import entities.AulaRecursos;
import entities.Horario;
import entities.Personal;
import entities.Reservas;
import identifiers.ReservasId;

@Controller
public class BookingController {

	private static final Logger LOGGER = LogManager.getLogger(BookingController.class.getName());
	private BookingDAO bookingDAO;
	private ClassroomDAO classroomDAO;
	private TimeDAO timeDAO;
	private PersonalDAO personalDAO;

	@Autowired
	public void setBookingDAO(BookingDAO bookingDAO) {
		this.bookingDAO = bookingDAO;
	}

	@Autowired
	public void setClassroomDAO(ClassroomDAO classroomDAO) {
		this.classroomDAO = classroomDAO;
	}

	@Autowired
	public void setTimeDAO(TimeDAO timeDAO) {
		this.timeDAO = timeDAO;
	}

	@Autowired
	public void setPersonalDAO(PersonalDAO personalDAO) {
		this.personalDAO = personalDAO;
	}

	public List<Reservas> getAll() {

		return bookingDAO.findAll();
	}

	// Busca Aulas Reservadas por fecha y horario
	public List<Aula> findClassroomsBooking(Date fecha, String horario) {

		List<Reservas> bookingList = bookingDAO.findClassroomsBookingByDate(fecha);

		List<Aula> classList = new ArrayList<Aula>();

		// SEPARAMOS POR HORARIO
		String horarios[] = horario.split(",");
		for (int i = 0; i < horarios.length; i++) {
			for (Reservas booking : bookingList) {
				// Busca todas las reservadas en un fecha y horario

				if (booking.getHorario().getId() == Integer.parseInt(horarios[i])) {
					classList.add(booking.getAula());
				}
			}

		}
		classList = new ArrayList<Aula>(new HashSet<Aula>(classList));

		return classList;
	}

	// Busca todas las aulas que no esten reservadas en unos determinados rangos
	// de fecha
	// Pendiente revisar hasmap
	public List<Aula> findClassroomsfree(Date fecha, String horario, String recursos) {
		List<Aula> classList = classroomDAO.findAll();
		List<Aula> bookingList = findClassroomsBooking(fecha, horario);

		HashMap<String, Aula> classMap = new HashMap<String, Aula>();
		for (Aula aula : classList) {
			classMap.put(aula.getId().toString(), aula);
		}

		for (Aula book : bookingList) {
			for (Aula free : classList) {
				if (free.getId().equals(book.getId())) {
					classMap.remove(free.getId().toString());

				}

			}

		}

		List<Aula> listClass = new ArrayList<Aula>(classMap.values());
		return findClassroomsResources(listClass, recursos);

		//
	}

	public List<Aula> findClassroomsResources(List<Aula> listClass, String recursos) {
		HashMap<String, Aula> classMap = new HashMap<String, Aula>();
		String listRecursos[] = recursos.split(",");
		int totalRecursos = 0;

		for (Aula aula : listClass) {
			totalRecursos = 0;
			Set<AulaRecursos> recursossss = new HashSet<AulaRecursos>(aula.getAulaRecursoses());
			for (Iterator<AulaRecursos> iterator = recursossss.iterator(); iterator.hasNext();) {
				AulaRecursos nombre = iterator.next();

				for (int i = 0; i < listRecursos.length; i++) {
					if (nombre.getId().getIdRecurso() == Integer.parseInt(listRecursos[i])) {
						totalRecursos++;
					}
				}

				if (totalRecursos == listRecursos.length) {
					classMap.put(aula.getId().toString(), aula);
				}
			}

		}
		List<Aula> resultAula = new ArrayList<Aula>(classMap.values());
		return resultAula;

	}

	public void addBooking(Reservas booking) {

		java.util.Date today = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(today.getTime());
		Aula aula = classroomDAO.findOne(booking.getId().getIdAula());
		Horario horario = timeDAO.findOne(booking.getId().getIdHorario());
		Reservas reserva = new Reservas();
		try {

			// Personal
			Personal personal = personalDAO.findOne(booking.getId().getIdPersonal());
			ReservasId idReserva = new ReservasId();
			idReserva.setFechaReserva(booking.getId().getFechaReserva());
			idReserva.setIdAula(aula.getId());
			idReserva.setIdHorario(horario.getId());
			idReserva.setIdPersonal(personal.getId());
			reserva.setAula(aula);
			reserva.setHorario(horario);
			reserva.setDescripcion(booking.getDescripcion());
			reserva.setPersonal(personal);
			reserva.setId(idReserva);
			reserva.setFechaOperacion(sqlDate);
			reserva.setEstado(false);
			bookingDAO.save(reserva);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} finally {

		}

	}

	// Mis reservas por persona reservada
	public List<Reservas> findClassroomsBookingByDate(Date fecha, int idPersonal) {
		if (idPersonal == 0) {
			return bookingDAO.findClassroomsBookingByDate(fecha);
		} else {
			return bookingDAO.findClassroomsBookingByDate(fecha, idPersonal);
		}

	}

	public List<Reservas> findClassroomsBookingByDateAndState(Date fecha, Boolean estado, int idPersonal) {
		if (idPersonal == 0) {
			return bookingDAO.findClassroomsBookingByDateAndState(fecha, estado);
		} else {
			return bookingDAO.findClassroomsBookingByDateAndState(fecha, estado, idPersonal);
		}

	}

	public void removeBooking(int idPersonal, int idAula, Date fechaReserva, int idHorario) {

		Reservas reservas = bookingDAO.findByID(idPersonal, idAula, fechaReserva, idHorario);
		bookingDAO.delete(reservas);

	}

	public void acceptBooking(int idPersonal, int idAula, Date fechaReserva, int idHorario) {
		Reservas reservas = bookingDAO.findByID(idPersonal, idAula, fechaReserva, idHorario);
		reservas.setEstado(true);
		bookingDAO.save(reservas);

	}

	public List<Reservas> findByPersonal(int idPersonal) {
		return bookingDAO.findByPersonal(idPersonal);

	}

	// Mis reservas por maestro de Laboratorio
	public List<Reservas> findClassroomsBookingByDateMaster(Date fecha, int idMaestro) {

		return bookingDAO.findClassroomsBookingByDateMaster(fecha, idMaestro);

	}

	public List<Reservas> findClassroomsBookingByDateAndStateMaster(Date fecha, Boolean estado, int idMaestro) {

		return bookingDAO.findClassroomsBookingByDateAndStateMaster(fecha, estado, idMaestro);

	}

	public List<Reservas> getByMaster(int idMaestro) {
		return bookingDAO.getByMaster(idMaestro);
	}

	public boolean addBookingCustomize(int idAula, Date fechaInicial, Date fechaFinal, String dias, String horario,
			int personal, String descripcion) {
		boolean resultado = false;
		java.util.Date fechaI = new Date(fechaInicial.getTime());
		java.util.Date fechaF = new Date(fechaFinal.getTime());

		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		Calendar current = Calendar.getInstance();

		start.setTime(fechaI);
		end.setTime(fechaF);
		current.setTime(fechaI);
		String listaDias[] = dias.split(",");
		String listaHorarios[] = horario.split(",");

		while (end.getTime().compareTo(current.getTime()) >= 0) {
			// verifico si es todos los dias
			if (Integer.parseInt(listaDias[0]) == 99) {
				for (int j = 0; j < listaHorarios.length; j++) {
					java.util.Date date = current.getTime();
					resultado = saveBooking(idAula, date, Integer.parseInt(listaHorarios[j]), personal, descripcion);

				}
			} else {

				for (int i = 0; i < listaDias.length; i++) {
					if (current.get(Calendar.DAY_OF_WEEK) == Integer.parseInt(listaDias[i])) {
						for (int j = 0; j < listaHorarios.length; j++) {
							java.util.Date date = current.getTime();
							resultado = saveBooking(idAula, date, Integer.parseInt(listaHorarios[j]), personal,
									descripcion);
						}
					}
				}
			}

			current.add(Calendar.DAY_OF_YEAR, 1);

		}
		if (!resultado) {
			return false;
		} else {
			return true;
		}

	}

	public boolean saveBooking(int aula, java.util.Date date, int horario, int personal, String descripcion) {

		java.util.Date today = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(today.getTime());
		java.sql.Date reservaDate = new java.sql.Date(date.getTime());
		Aula myAula = classroomDAO.findOne(aula);
		Horario myTime = timeDAO.findOne(horario);
		// Reservas reserva = new Reservas();
		Reservas reserva = bookingDAO.findByID(personal, aula, reservaDate, horario);

		if (reserva == null) {
			// Personal
			reserva = new Reservas();
			Personal myPersonal = personalDAO.findOne(personal);
			ReservasId idReserva = new ReservasId();
			idReserva.setFechaReserva(reservaDate);
			idReserva.setIdAula(myAula.getId());
			idReserva.setIdHorario(myTime.getId());
			idReserva.setIdPersonal(myPersonal.getId());
			reserva.setAula(myAula);
			reserva.setHorario(myTime);
			reserva.setDescripcion(descripcion);
			reserva.setPersonal(myPersonal);
			reserva.setId(idReserva);
			reserva.setFechaOperacion(sqlDate);
			reserva.setEstado(false);
			bookingDAO.save(reserva);
			return true;
		} else {
			return false;
		}

	}

}
