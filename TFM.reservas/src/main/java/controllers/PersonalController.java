package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import daos.BookingDAO;
import daos.ClassroomDAO;
import daos.PermisosDAO;
import daos.PersonalDAO;
import entities.Aula;
import entities.Personal;
import entities.Reservas;

@Controller
public class PersonalController {

	private PersonalDAO personalDao;

	private ClassroomDAO aulalDao;
	
	private PermisosDAO permisosDAO;

	private BookingDAO bookingDAO;

	@Autowired
	public void setPersonalDAO(PersonalDAO personalDao) {
		this.personalDao = personalDao;
	}

	@Autowired
	public void setBookingDAO(BookingDAO bookingDAO) {
		this.bookingDAO = bookingDAO;
	}

	@Autowired
	public void setAulalDAO(ClassroomDAO aulalDao) {
		this.aulalDao = aulalDao;
	}

	@Autowired
	public void setPermisosDAO(PermisosDAO permisosDAO) {
		this.permisosDAO = permisosDAO;
	}

	public List<Personal> getAll() {
		List<Personal> personal = personalDao.findAll();
		return personal;
	}

	public Personal searchByID(int id) {
		Personal personal = new Personal();
		personal = personalDao.findOne(id);
		return personal;

	}

	public void removePersonal(int id) {

		List<Aula> classroomList = aulalDao.findbyPersonal(id);
		for (Aula classroom : classroomList) {
			classroom.setPersonal(null);
			aulalDao.save(classroom);

		}
		
		List<Reservas> bookingList = bookingDAO.findByPersonal(id);
		if(!bookingList.isEmpty()){
			for (Reservas reserva : bookingList){
				bookingDAO.delete(reserva);
			}
			
		}

		personalDao.delete(id);

	}

	public void addPersonal(Personal personal) {
		personal.setPermisos(permisosDAO.findOne(personal.getPermisos().getId()));
		personalDao.save(personal);

	}

	public List<Personal> findMaestroLaboratorio() {

		List<Personal> personas = personalDao.findMaestroLaboratorio();
		return personas;

	}

	public Personal searchByUsername(String username) {
		Personal personal = new Personal();
		personal = personalDao.searchByUsername(username);
		return personal;
	}

}
