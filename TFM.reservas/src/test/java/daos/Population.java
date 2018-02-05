package daos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import entities.Aula;
import entities.AulaRecursos;
import entities.Horario;
import entities.Permisos;
import entities.Personal;
import entities.Recursos;
import entities.Reservas;
import identifiers.AulaRecursosId;
import identifiers.ReservasId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class, TestsPersistenceConfig.class })
public class Population {

	 @Autowired
	 private BookingDAO bookingDAO;

	@Autowired
	private ClassroomDAO classroomDAO;

	@Autowired
	private PersonalDAO personalDAO;

	@Autowired
	private ResourcesDAO resourcesDAO;

	@Autowired
	private ResourcesClassroomDAO resourcesClassroomDAO;
	
	@Autowired
	private TimeDAO timeDAO;

	@Test
	public void populate() {
		this.clean();
		this.createRecursos();
		this.createPersonal();
		this.createAulas();
		this.createAulaRecursos();
		this.createReservas();

	}

	

	private void createAulaRecursos() {

		Aula aula1 = classroomDAO.searchByReferencia(1001);
		Aula aula2 = classroomDAO.searchByReferencia(1002);
		Aula aula3 = classroomDAO.searchByReferencia(1003);

		Recursos recurso1 = resourcesDAO.searchByNombre("PC");
		Recursos recurso2 = resourcesDAO.searchByNombre("MAC");
		Recursos recurso3 = resourcesDAO.searchByNombre("Proyector");
		Recursos recurso4 = resourcesDAO.searchByNombre("Pizarra Electronica");
		Recursos recurso5 = resourcesDAO.searchByNombre("Pizarra");

		AulaRecursosId aulaRecursosId1 = new AulaRecursosId(aula1.getId(), recurso1.getId());
		AulaRecursosId aulaRecursosId2 = new AulaRecursosId(aula1.getId(), recurso3.getId());
		AulaRecursosId aulaRecursosId3 = new AulaRecursosId(aula1.getId(), recurso5.getId());
		AulaRecursosId aulaRecursosId4 = new AulaRecursosId(aula2.getId(), recurso2.getId());
		AulaRecursosId aulaRecursosId5 = new AulaRecursosId(aula2.getId(), recurso4.getId());
		AulaRecursosId aulaRecursosId6 = new AulaRecursosId(aula2.getId(), recurso3.getId());
		
		AulaRecursosId aulaRecursosId7 = new AulaRecursosId(aula3.getId(), recurso1.getId());
		AulaRecursosId aulaRecursosId8 = new AulaRecursosId(aula3.getId(), recurso3.getId());
		AulaRecursosId aulaRecursosId9 = new AulaRecursosId(aula3.getId(), recurso4.getId());
		

		AulaRecursos aR1 = new AulaRecursos();
		aR1.setId(aulaRecursosId1);
		aR1.setCantidad(25);

		AulaRecursos aR2 = new AulaRecursos();
		aR2.setId(aulaRecursosId2);
		aR2.setCantidad(25);

		AulaRecursos aR3 = new AulaRecursos();
		aR3.setId(aulaRecursosId3);
		aR3.setCantidad(25);

		AulaRecursos aR4 = new AulaRecursos();
		aR4.setId(aulaRecursosId4);
		aR4.setCantidad(25);

		AulaRecursos aR5 = new AulaRecursos();
		aR5.setId(aulaRecursosId5);
		aR5.setCantidad(25);

		AulaRecursos aR6 = new AulaRecursos();
		aR6.setId(aulaRecursosId6);
		aR6.setCantidad(25);

		AulaRecursos aR7 = new AulaRecursos();
		aR7.setId(aulaRecursosId7);
		aR7.setCantidad(25);

		AulaRecursos aR8 = new AulaRecursos();
		aR8.setId(aulaRecursosId8);
		aR8.setCantidad(25);

		AulaRecursos aR9 = new AulaRecursos();
		aR9.setId(aulaRecursosId9);
		aR9.setCantidad(25);

		resourcesClassroomDAO.save(aR1);
		resourcesClassroomDAO.save(aR2);
		resourcesClassroomDAO.save(aR3);
		resourcesClassroomDAO.save(aR4);
		resourcesClassroomDAO.save(aR5);
		resourcesClassroomDAO.save(aR6);
		resourcesClassroomDAO.save(aR7);
		resourcesClassroomDAO.save(aR8);
		resourcesClassroomDAO.save(aR9);

	}

	private void createAulas() {
		Aula aula1 = new Aula(1001, 1.1, true, personalDAO.searchByUsername("Maestro1"));
		Aula aula2 = new Aula(1002, 1.2, true, personalDAO.searchByUsername("Maestro1"));
		Aula aula3 = new Aula(1003, 1.3, true, personalDAO.searchByUsername("Maestro1"));

		Aula aula4 = new Aula(1004, 1.4, true, personalDAO.searchByUsername("Maestro2"));
		Aula aula5 = new Aula(1005, 1.5, true, personalDAO.searchByUsername("Maestro2"));
		Aula aula6 = new Aula(1006, 1.6, true, personalDAO.searchByUsername("Maestro2"));

		Aula aula7 = new Aula(1007, 1.7, true, personalDAO.searchByUsername("Maestro3"));
		Aula aula8 = new Aula(1007, 1.8, true, personalDAO.searchByUsername("Maestro3"));
		Aula aula9 = new Aula(1009, 1.9, true, personalDAO.searchByUsername("Maestro3"));

		classroomDAO.save(aula1);
		classroomDAO.save(aula2);
		classroomDAO.save(aula3);
		classroomDAO.save(aula4);
		classroomDAO.save(aula5);
		classroomDAO.save(aula6);
		classroomDAO.save(aula7);
		classroomDAO.save(aula8);
		classroomDAO.save(aula9);

	}

	private void createPersonal() {

		Personal administrador = new Personal(new Permisos(1, "Administrador", "XXXXX"), "Administrador", "Apellido 1 Apellido 2",
				"admin", "admin");
		
		Personal director = new Personal(new Permisos(2, "Director", "XXXX"), "Director", "Apellido 1 Apellido 2",
				"director", "1234");

		Personal maestro1 = new Personal(new Permisos(3, "Maestro de Laboratorio", "XXX"), "Maestro 1",
				"Apellido 3 Apellido 4", "maestro1", "1234");
		Personal maestro2 = new Personal(new Permisos(3, "Maestro de Laboratorio", "XXX"), "Maestro 2",
				"Apellido 5 Apellido 6", "maestro2", "1234");
		Personal maestro3 = new Personal(new Permisos(3, "Maestro de Laboratorio", "XXX"), "Maestro 3",
				"Apellido 7 Apellido 8", "maestro3", "1234");

		Personal profesor1 = new Personal(new Permisos(4, "Profesor", "XX"), "Profesor 1", "Apellido 1 Apellido 2",
				"profesor1", "1234");
		Personal profesor2 = new Personal(new Permisos(4, "Profesor", "XX"), "Profesor 2", "Apellido 3 Apellido 4",
				"profesor2", "1234");
		Personal profesor3 = new Personal(new Permisos(4, "Profesor", "XX"), "Profesor 3", "Apellido 5 Apellido 6",
				"profesor3", "1234");
		Personal profesor4 = new Personal(new Permisos(4, "Profesor", "XX"), "Profesor 4", "Apellido 7 Apellido 8",
				"profesor4", "1234");

		personalDAO.save(administrador);
		personalDAO.save(director);
		personalDAO.save(maestro1);
		personalDAO.save(maestro2);
		personalDAO.save(maestro3);
		personalDAO.save(profesor1);
		personalDAO.save(profesor2);
		personalDAO.save(profesor3);
		personalDAO.save(profesor4);
	}

	private void createRecursos() {
		Recursos recurso1 = new Recursos("PC", "Ordenadores");
		Recursos recurso2 = new Recursos("MAC", "Ordenadores");
		Recursos recurso3 = new Recursos("Proyector", "Sony");
		Recursos recurso4 = new Recursos("Pizarra Electronica", "Phillip");
		Recursos recurso5 = new Recursos("Pizarra", "-");
		resourcesDAO.save(recurso1);
		resourcesDAO.save(recurso2);
		resourcesDAO.save(recurso3);
		resourcesDAO.save(recurso4);
		resourcesDAO.save(recurso5);

	}
	

	private void createReservas() {
		
		List<Personal> personalList = new ArrayList<>();
		personalList = personalDAO.findAll();
		
		List<Aula> aulaList = new ArrayList<>();
		aulaList = classroomDAO.findAll();
		
		List<Horario> horarioList = new ArrayList<>();
		horarioList = timeDAO.findAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String dateInString = "2018-01-29";
		java.util.Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.util.Date today = new java.util.Date();
		java.sql.Date sqlDate2 = new java.sql.Date(today.getTime());
	
		
		
		java.sql.Date sqlDate1 = new java.sql.Date(date.getTime());
		
		for(Aula aula : aulaList){
			for(Personal personal : personalList){
				ReservasId idReserva = new ReservasId(personal.getId(),aula.getId(),sqlDate1, horarioList.get(1).getId());
				Reservas reserva = new Reservas();
				reserva.setId(idReserva);
				reserva.setFechaOperacion(sqlDate2);
				reserva.setHorario( horarioList.get(1));
				reserva.setPersonal(personal);
				reserva.setAula(aula);
				reserva.setEstado(false);
				reserva.setDescripcion("Population");
				bookingDAO.save(reserva);
			}
			
		}
		
		
		

	}
	
	public void clean() {
		bookingDAO.deleteAll();
		resourcesClassroomDAO.deleteAll();
		resourcesDAO.deleteAll();
		classroomDAO.deleteAll();
		personalDAO.deleteAll();
		
	
	

	}

}
