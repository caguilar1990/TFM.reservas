package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import daos.BookingDAO;
import daos.ClassroomDAO;
import daos.PersonalDAO;
import daos.ResourcesClassroomDAO;
import entities.Aula;
import entities.AulaRecursos;
import entities.Personal;
import entities.Reservas;

@Controller
public class ClassroomController {

	private ClassroomDAO aulaDao;
	private PersonalDAO personalDAO;
	private ResourcesClassroomDAO resourcesClassDAO;
	private BookingDAO bookingDAO;


	@Autowired
	public void setAulaDAO(ClassroomDAO aulaDao) {
		this.aulaDao = aulaDao;
	}

	@Autowired
	public void setpersonalDAO(PersonalDAO personalDAO) {
		this.personalDAO = personalDAO; 
	}
	
	@Autowired
	public void setResourcesClassroomDAO(ResourcesClassroomDAO resourcesClassDAO) {
		this.resourcesClassDAO = resourcesClassDAO;
	}
	
	
	@Autowired
	public void setBookingDAO(BookingDAO bookingDAO) {
		this.bookingDAO = bookingDAO;
	}
	

	
	public List<Aula> getAll() {
		
		try{
			List <Aula> aula = aulaDao.findAll();
			return aula;
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	public Aula searchByID(int id) {
		Aula aula = null;
		aula = aulaDao.findOne(id);
			return aula;
	
	}

	public void updateAula(Aula classroom) {
		Aula aulaUpdate = aulaDao.findOne(classroom.getId());
		Personal personalUpdate = personalDAO.findOne(classroom.getPersonal().getId());
		
		if (aulaUpdate != null) {
			try{
			aulaUpdate.setSuperficie(classroom.getSuperficie());
			aulaUpdate.setAccesibilidad(classroom.getAccesibilidad());
			aulaUpdate.setPersonal(personalUpdate);
			this.aulaDao.save(aulaUpdate);
		}catch (Exception ex){
			System.out.println(ex.getMessage());
			}
		}

	}

	public void removeAula(int id) {
		try{
		List<AulaRecursos> resourcesClassList	=resourcesClassDAO.findbyIDAula(id);
		if(!resourcesClassList.isEmpty()){
			for (AulaRecursos resourcesClass : resourcesClassList){
				resourcesClassDAO.delete(resourcesClass);
			}
			
		}
		
		List<Reservas> bookingList = bookingDAO.searchByClass(id);
		
		if(!bookingList.isEmpty()){
			for (Reservas reserva : bookingList){
				bookingDAO.delete(reserva);
			}
			
		}
		aulaDao.delete(id);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

	public void addAula(Aula aula) {
		aulaDao.save(aula);
		
	}

	public List<Aula> findbyPersonal(int id) {
		List <Aula> aula = aulaDao.findbyPersonal(id);
		return aula;
	}
	


}

